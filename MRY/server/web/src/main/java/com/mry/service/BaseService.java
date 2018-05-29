package com.mry.service;


import com.mry.cometd.app.Application;
import com.mry.entity.common.UserSession;
import com.mry.entity.admin.AdminUser;
import com.mry.entity.admin.AdminUserSession;
import com.mry.entity.common.City;
import com.mry.entity.common.Province;
import com.mry.entity.common.image.Image;
import com.mry.entity.common.image.ImageWrapper;
import com.mry.entity.dao.AdminUserDao;
import com.mry.entity.dao.CommonDao;
import com.mry.entity.dao.ConfigDao;
import com.mry.entity.user.Customer;
import com.mry.entity.user.CustomerSession;
import com.mry.entity.user.Staff;
import com.mry.entity.user.StaffSession;
import com.mry.entity.user.data.UserType;
import com.mry.exception.BusinessException;
import com.mry.exception.ErrorCode;
import com.mry.json.CityJson;
import com.mry.json.ImageBinary;
import com.mry.json.ProvinceForJson;
import com.mry.service.helper.AuthTokenHelper;
import com.mry.service.helper.PicProcessType;
import com.mry.service.helper.PictureHelper;
import com.mry.util.Constants;
import com.mry.util.DatetimeUtil;
import com.mry.util.properties.CommonPropertiesUtil;
import com.mry.util.properties.ConfigPropertiesUtil;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BaseService {

    public static final String SYS_ADMIN = CommonPropertiesUtil.getString("system.administrator");
    public static final String SYS_AUTO = CommonPropertiesUtil.getString("system.auto.send");

    @Resource
    private AdminUserDao adminUserDao;

    @Resource
    private ConfigDao configDao;

    @Resource
    private CommonDao commonDao;



    public static final int IMAGE_MAX_SIZE = ConfigPropertiesUtil.getInt("max.pic.size", 20 * 1024 * 1024);

    protected String formatDatetime(Date date) {
        return DatetimeUtil.formatDatetime(date);
    }

    protected String formatDate(Date date) {
        return DatetimeUtil.formatDate(date);
    }

    @Transactional
    public boolean checkUserSessionErrorOrExpired(String authToken) {
        UserType type = AuthTokenHelper.resolveAuthToken(authToken);
        if (type == null) {
            return true;
        }
        UserSession session = adminUserDao.findUserSessionByAuthToken(authToken, type);
        if (session == null) {
            return true;
        }

        int hours = configDao.getConfigAuthTokenExpireHours();
        boolean expired = checkExpired(session.getStartTime(), hours);


        return expired;
    }

    private UserSession checkUserSession(String authToken, UserType type) {
        UserSession session = adminUserDao.findUserSessionByAuthToken(authToken, type);
        if (session == null) {
            throw new BusinessException(ErrorCode.AUTHTOKEN_ERROR);
        }

        int hours = configDao.getConfigAuthTokenExpireHours();
        boolean expired = checkExpired(session.getStartTime(), hours);
        if (expired) {
            session.setExpired(true);
            adminUserDao.updateObject(session);
            throw new BusinessException(ErrorCode.AUTHTOKEN_ERROR);
        }
        return session;
    }






    protected static boolean checkExpired(Date startTime, int expireHours) {
        Instant start = startTime.toInstant();
        start = start.plus(expireHours, ChronoUnit.HOURS);

        return Instant.now().isAfter(start);
    }

    public UserType getUserTypeWithCheckAuthToken(String authToken) {
        if (authToken != null && !checkUserSessionErrorOrExpired(authToken)) {
            return AuthTokenHelper.resolveAuthToken(authToken);
        }
        return null;
    }

//    @Transactional
//    public CommonUser getUserByAuthToken(String authToken) {
//        UserType type = AuthTokenHelper.resolveAuthToken(authToken);
//        if (type == null) {
//            throw new BusinessException(ErrorCode.AUTHTOKEN_ERROR);
//        }
//
//        UserSession session = checkUserSession(authToken, type);
//
//        if (UserType.CUSTOMER.equals(type)) {
//            return ((CustomerSession) session).getCustomer();
//        } else {
//            // return ((DoctorSession) session).getDoctor();
//            return null;
//        }
//    }

    public Customer getCustomerByAuthToken(String authToken) {
        UserType type = AuthTokenHelper.resolveAuthToken(authToken);
        if (type == null) {
            throw new BusinessException(ErrorCode.AUTHTOKEN_ERROR);
        }

        UserSession session = checkUserSession(authToken, type);

        if (UserType.CUSTOMER.equals(type)) {
            return ((CustomerSession) session).getCustomer();
        } else {
            // return ((DoctorSession) session).getDoctor();
            return null;
        }
    }




    @Transactional
    public Staff getStaffByAuthToken(String authToken) {
        UserSession session = getUserByAuthToken(authToken, UserType.STAFF, ErrorCode.AUTHTOKEN_ERROR);

        return ((StaffSession) session).getStaff();
    }

    private UserSession getUserByAuthToken(String authToken, UserType userType, ErrorCode errorCode) {
        return checkUserSession(authToken, userType);
    }

    protected AdminUser findAdminUserByAuthToken(String authToken) {
        AdminUserSession session = adminUserDao.findAdminUserSessionByAuthToken(authToken);
        if (session != null) {
            return session.getAdmin();
        }
        throw new BusinessException(ErrorCode.AUTHTOKEN_ERROR);
    }



    public byte[] convertBinaryToByteArray(String base64String) {
        byte[] imageData = java.util.Base64.getDecoder().decode(base64String);
        if (imageData.length > IMAGE_MAX_SIZE) {
            throw new BusinessException(ErrorCode.IMAGE_TOO_BIG);
        }
        return imageData;
    }

    protected ImageWrapper processImages(List<ImageBinary> binaries, boolean needThumbnail) {
        if (binaries == null || binaries.size() == 0) {
            return null;
        }

        ImageWrapper wrapper = new ImageWrapper();
        wrapper.setLastUpdateTime(new Date());
        wrapper = adminUserDao.updateObject(wrapper);

        List<Image> images = new ArrayList<Image>();
        for (ImageBinary img : binaries) {
            if (img.getId() != null) {
                Image image = commonDao.find(Image.class, img.getId());
                if (image != null) {
                    image.setWrapper(wrapper);
                    images.add(image);
                }
            } else if (img.getBinary() != null) {
                byte[] data = convertBinaryToByteArray(img.getBinary());
                String url = PictureHelper.savePic(Application.getFilePath(), data, PicProcessType.BUSINESS);
                String original = PictureHelper.savePic(Application.getFilePath(), data, PicProcessType.ORIGINAL);
                String thumbnail = null;
                if (needThumbnail) {
                    thumbnail = PictureHelper.savePic(Application.getFilePath(), data, PicProcessType.THUMBNAIL);
                }

                Image image = new Image();
                image.setName(img.getName());
                image.setNormalUrl(url);
                image.setOriginalUrl(original);
                image.setThumbnailUrl(thumbnail);
                image.setAddTime(new Date());
                image.setWrapper(wrapper);

                images.add(image);
            }
        }

        wrapper.setImages(images);
        wrapper = adminUserDao.updateObject(wrapper);
        return wrapper;
    }

    protected ImageWrapper processImages(List<ImageBinary> binaries) {
        return processImages(binaries, false);
    }

    protected ImageWrapper updateImages(List<ImageBinary> updateImages, ImageWrapper wrapper, boolean needThumbnail) {
        if (wrapper == null) {
            wrapper = new ImageWrapper();
        }
        List<Image> oldImages = wrapper.getImages();

        List<Image> newImages = new ArrayList<Image>();

        for (ImageBinary img : updateImages) {
            if (img.getId() != null) {
                Image image = adminUserDao.find(Image.class, img.getId());
                if (checkExistImage(oldImages, image)) {
                    newImages.add(image);
                }
            }
            if (img.getId() == null && img.getBinary() != null) {
                byte[] data = convertBinaryToByteArray(img.getBinary());
                String url = PictureHelper.savePic(Application.getFilePath(), data, PicProcessType.BUSINESS);
                String original = PictureHelper.savePic(Application.getFilePath(), data, PicProcessType.ORIGINAL);
                String thumbnail = null;
                if (needThumbnail) {
                    thumbnail = PictureHelper.savePic(Application.getFilePath(), data, PicProcessType.THUMBNAIL);
                }

                Image image = new Image();
                image.setName(img.getName());
                image.setNormalUrl(url);
                image.setOriginalUrl(original);
                image.setThumbnailUrl(thumbnail);
                image.setAddTime(new Date());
                image.setWrapper(wrapper);
                newImages.add(image);
            }

        }

        for (Image image : oldImages) {
            if (!checkContainOldImage(updateImages, image.getId())) {
                commonDao.removeObject(image);
            }
        }

        wrapper.setImages(newImages);
        wrapper = commonDao.updateObject(wrapper);
        return wrapper;
    }

    private boolean checkContainOldImage(List<ImageBinary> updateImages, Long imageId) {
        for (ImageBinary img : updateImages) {
            if (img.getId() != null && img.getId().equals(imageId)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkExistImage(List<Image> images, Image image) {
        for (Image m : images) {
            if (image.getId().equals(m.getId())) {
                return true;
            }
        }
        return false;
    }

    protected ImageWrapper updateImages(List<ImageBinary> updateImages, ImageWrapper wrapper) {
        return updateImages(updateImages, wrapper, true);
    }

    protected CityJson convertCity(City city) {
        return new CityJson(city.getId(), city.getName());
    }

    protected ProvinceForJson convertProvince(Province province) {
        return new ProvinceForJson(province.getId(), province.getName());
    }


    protected int calcPages(Long total, Integer pageSize) {
        if (pageSize == null || pageSize < 1) {
            pageSize = Constants.DEFAULT_PAGE_SIZE;
        }

        int pages = total.intValue() / pageSize;
        if (pages * pageSize != total) {
            pages++;
        }
        return pages;
    }

    @Transactional
    public void save(Object obj) {
        adminUserDao.saveObject(obj);
    }

    @Transactional
    public <T> T update(T t) {
        return adminUserDao.updateObject(t);
    }





    protected List<ImageBinary> convertImagesJson(ImageWrapper wrapper) {
        if (wrapper != null && wrapper.getImages() != null && wrapper.getImages().size() > 0) {
            List<ImageBinary> imgs = new ArrayList<ImageBinary>();
            for (Image image : wrapper.getImages()) {
                ImageBinary b = new ImageBinary();
                b.setId(image.getId());
                b.setUrl(image.getNormalUrl());
                b.setOriginalUrl(image.getOriginalUrl());
                imgs.add(b);
            }
            return imgs;
        }
        return null;
    }



}
