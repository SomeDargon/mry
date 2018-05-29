package com.mry.service.userInfo;

import com.mry.entity.dao.ConfigDao;
import com.mry.exception.BusinessException;
import com.mry.exception.ErrorCode;
import com.mry.json.admin.AdminLoginResponse;
import com.mry.json.admin.AdminLoginUser;
import com.mry.json.admin.AdminUserJson;
import com.mry.service.BaseService;
import com.mry.util.MyUtil;
import com.mry.util.properties.CommonPropertiesUtil;
import com.mry.cometd.service.NotificationService;
import com.mry.entity.admin.AdminUser;
import com.mry.entity.admin.AdminUserSession;
import com.mry.entity.dao.AdminUserDao;
import com.mry.security.PooledStrongPasswordEncryptor;
import com.mry.security.SecureTokenhelper;
import com.mry.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Date;
import java.util.Enumeration;

@Service
@Transactional
public class AdminService extends BaseService {
    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    private static final String MSG_HEADER = CommonPropertiesUtil.getString("system.bulletin.notify.message.header");

    @Autowired
    protected NotificationService notificationService;
    @Resource
    private AdminUserDao adminUserDao;

    @Resource
    private ConfigDao configDao;


    public boolean checkAdminUserSessionErrorOrExpired(String authToken) {
        AdminUserSession session = adminUserDao.findAdminUserSessionByAuthToken(authToken);
        if (session == null) {
            return true;
        }
        int hours = configDao.getConfigAdminAuthTokenExpireHours();
        boolean isExpired = checkExpired(session.getStartTime(), hours);

        if (isExpired) {
            session.setExpired(true);
            adminUserDao.updateObject(session);
        }
        return isExpired;
    }

    public AdminLoginResponse login(AdminLoginUser loginUser, HttpServletRequest request) {
        AdminUser user = adminUserDao.findAdminUser(loginUser.getUsername());
        if (user == null) {
            throw new BusinessException(ErrorCode.NOT_EXIST_ACCOUNT);
        }

        if (!PooledStrongPasswordEncryptor.getInstance().checkPassword(loginUser.getPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
        }

        String token = SecureTokenhelper.createToken(null);

        AdminUserSession session = new AdminUserSession();
        session.setAuthToken(token);
        session.setStartTime(new Date());
        session.setExpired(false);
        session.setAdmin(user);

        adminUserDao.updateObject(session);

        AdminLoginResponse result = new AdminLoginResponse();
        result.setUsername(user.getUsername());
        result.setAuthToken(token);
        result.setAdminType(user.getAdminType());

        return result;
    }

    public AdminUser getAdminByAuthToken(String authToken) {
        return findAdminUserByAuthToken(authToken);
    }




    private String getSummary(String content) {
        String noHtmlContent = MyUtil.stripHtmlTags(content);
        int summaryLen = noHtmlContent.length() > Constants.BULLETIN_SUMMARY_LEN ? Constants.BULLETIN_SUMMARY_LEN
                : noHtmlContent.length();
        String summary = noHtmlContent.substring(0, summaryLen);
        return summary;
    }




    /**
     * 验证管理员账号
     *
     * @param user
     * @return
     */
    public Boolean validateAdmin(AdminLoginUser user) {
        AdminUser adminUser = adminUserDao.findAdminUser(user.getUsername());
        if (adminUser == null || !PooledStrongPasswordEncryptor.getInstance().checkPassword(user.getPassword(), adminUser.getPassword())) {
            return false;
        } else return true;
    }

    public boolean registerAdminUser(AdminUserJson user, String authToken){
        boolean res=false;
        if(getAdminByAuthToken(authToken).getAdminType()==1) {
            if(user.getAdminType()!=null&&user.getUsername()!=null&&user.getAdminType()!=null){
                if(adminUserDao.findAdminUser(user.getUsername())==null){
            AdminUser adminUser = new AdminUser();
            adminUser.setUsername(user.getUsername());
            adminUser.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword(user.getUserPassWord()));
            adminUser.setAdminType(user.getAdminType());
            adminUser.setActive(true);
                    adminUserDao.updateObject(adminUser);
                    return  true;
                }else{
                    throw new BusinessException(ErrorCode.ADMIN_USER_NAME_REPEAT);
                }
            }else{
                throw new BusinessException(ErrorCode.ADMIN_INFORMATION_ISNOTNULL);
            }
        }else throw new BusinessException(ErrorCode.ADMIN_INADEQUATE_PERMISSION);
    }


    public boolean deleteAdminUser(Long id,String authToken){
        if(getAdminByAuthToken(authToken).getAdminType()==1) {
            return adminUserDao.deleteAdminUser(id) != 0;
        }else throw new BusinessException(ErrorCode.ADMIN_INADEQUATE_PERMISSION);
    }




//获取操作者当前IP
    public static String getMyIp() {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP
        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            boolean finded = false;// 是否找到外网IP
            while (netInterfaces.hasMoreElements() && !finded) {
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                Enumeration address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    ip = (InetAddress) address.nextElement();
                    if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                        netip = ip.getHostAddress();
                        finded = true;
                        break;
                    } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                        localip = ip.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }


}
