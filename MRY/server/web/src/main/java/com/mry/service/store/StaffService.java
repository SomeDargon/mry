package com.mry.service.store;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.store.StaffDao;
import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.entity.user.Customer;
import com.mry.entity.user.Staff;
import com.mry.entity.user.StaffManyCustomer;
import com.mry.entity.user.StaffSession;
import com.mry.entity.user.data.UserType;
import com.mry.exception.BusinessException;
import com.mry.exception.ErrorCode;
import com.mry.json.LoginResponseJson;
import com.mry.json.LoginUserJson;
import com.mry.json.ResultsWrapper;
import com.mry.json.store.QuitJson;
import com.mry.json.store.StaffJson;
import com.mry.json.store.StaffListJson;
import com.mry.security.PooledStrongPasswordEncryptor;
import com.mry.security.SecureTokenhelper;
import com.mry.service.BaseService;
import com.mry.util.DatetimeUtil;
import com.mry.util.ip.IPSeeker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by kaik on 2017/10/27.
 */
@Service
@Transactional
public class StaffService extends BaseService {

    @Resource
    public StaffDao staffDao;



    public int save(String authToken, StaffJson data) {
        Staff user = getStaffByAuthToken(authToken);
     //   if (user.getRoleId() != 1l) {
//            throw new BusinessException(ErrorCode.INSUFFICIENT_AUTHORITY);
//        }
        Staff s = new Staff();
        s.setStoreName(user.getStoreName());
        s.setStoreId(user.getStoreId());
        s.setAccount(data.getPhoneNumber());
        //密码
        s.setCode(getCode(user.getStoreId()));
        s.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword("123456"));
        s.setRealName(data.getRealName());
     //   s.setCode(data.getCode());
        s.setPhoneNumber(data.getPhoneNumber());
        s.setBirthday(DatetimeUtil.getBirthday(data.getIdCardNumber()));
        s.setGender(DatetimeUtil.getGender(data.getIdCardNumber()));
        s.setIdCardNumber(data.getIdCardNumber());
        s.setPlaceOfOrigin(data.getPlaceOfOrigin());
        s.setAddress(data.getAddress());
        s.setEmail(data.getEmail());
        //头像
        s.setIconUrl(data.getIconUrl());
        s.setServiceIntroduction(data.getServiceIntroduction());
        //入职时间
        s.setEntryTime(DatetimeUtil.parseDate(data.getEntryTime()));
        //等级
        s.setGrade(data.getGrade());
        s.setGradeId(data.getGradeId());
        s.setStatus(data.getStatus());
        s.setReasonForLeave(data.getReasonForLeave());
        //离职
//        s.setEnable(data.getEnable());
//        s.setReason(data.getReason());
        s.setRoleName(data.getRoleName());
        s.setRoleId(data.getRoleId());
        s.setGroupName(data.getGroupName());
        s.setGroupId(data.getGroupId());
        s.setEnable(true);

        staffDao.save(s);

        return 1;
    }

    public int edit(String authToken, StaffJson data) {
        Staff s =staffDao.findById(data.getId());
        s.setAccount(data.getPhoneNumber());
        //密码
        s.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword(data.getPassword()));
        s.setRealName(data.getRealName());
        //   s.setCode(data.getCode());
        s.setPhoneNumber(data.getPhoneNumber());
        s.setBirthday(DatetimeUtil.getBirthday(data.getIdCardNumber()));
        s.setGender(DatetimeUtil.getGender(data.getIdCardNumber()));
        s.setIdCardNumber(data.getIdCardNumber());
        s.setPlaceOfOrigin(data.getPlaceOfOrigin());
        s.setAddress(data.getAddress());
        s.setEmail(data.getEmail());
        //头像
        s.setIconUrl(data.getIconUrl());
        s.setServiceIntroduction(data.getServiceIntroduction());
        //入职时间
        s.setEntryTime(DatetimeUtil.parseDate(data.getEntryTime()));
        //等级
        s.setGrade(data.getGrade());
        s.setGradeId(data.getGradeId());
        s.setStatus(data.getStatus());
        s.setReasonForLeave(data.getReasonForLeave());
        //离职
//        s.setEnable(data.getEnable());
//        s.setReason(data.getReason());
        s.setRoleName(data.getRoleName());
        s.setRoleId(data.getRoleId());
        s.setGroupName(data.getGroupName());
        s.setGroupId(data.getGroupId());
        s.setEnable(true);

        return 1;
    }

    public ResultsWrapper<StaffListJson> findUserList(String authToken,String name, Integer page, Integer pageSize){


        Staff user = getStaffByAuthToken(authToken);
        List<Staff> staffs = staffDao.findList(user.getStoreId(),name,page,pageSize);
        List<StaffListJson> json = new ArrayList<StaffListJson>();
        if (staffs.size()>0) {
            staffs.forEach(a ->json.add(new StaffListJson(a)));
        }
        Long count = staffDao.findListCount(user.getStoreId(),name);
        ResultsWrapper<StaffListJson> h = new ResultsWrapper<StaffListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));
        return  h;
    }

    public void delete(String authToken, Long id) {
    }



    public LoginResponseJson login(LoginUserJson loginUser, HttpServletRequest request) {

        Staff user = staffDao.findAccount(loginUser.getAccount());
        String ip = IPSeeker.getIpAddress(request);
        if(user != null && user.getEnable() == true){
            if (!PooledStrongPasswordEncryptor.getInstance().checkPassword(loginUser.getPassword(),
                    user.getPassword())) {
                throw new BusinessException(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
            }
            String token = SecureTokenhelper.createToken(UserType.STAFF);
            StaffSession session = new StaffSession();
            session.setAuthToken(token);
            session.setStartTime(new Date());
            session.setExpired(false);
            session.setStaff(user);
            session.setLogasguardian(false);
            staffDao.updateObject(session);

            user.setLastLoginTime(new Date());
            user.setLoginCount(user.getLoginCount()+1);
            staffDao.updateObject(user);
            LoginResponseJson result = new LoginResponseJson();
            result.setStoreId(user.getStoreId());
            result.setStoreName(user.getStoreName());
            result.setAuthToken(token);
            result.setAccount(user.getAccount());
            result.setId(user.getId());
            result.setRealName(user.getRealName());
            result.setPhoneNumber(user.getPhoneNumber());
            result.setIcon(user.getIconUrl());
            result.setGender(user.getGender());
            result.setRoleName(user.getRoleName());
            result.setRoleId(user.getRoleId());
            result.setAddress(user.getAddress());
            result.setGender(user.getGender());
            result.setLastLoginTime(DatetimeUtil.formatDate(user.getLastLoginTime()));
            result.setEmail(user.getEmail());
            result.setSystem(user.getSystem());

            return result;

        }
        throw new BusinessException(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
    }

    public Integer getErrorTime(Date first, Date last){
        Calendar cal = Calendar.getInstance();
        cal.setTime(first);
        long firstTime = cal.getTimeInMillis();
        cal.setTime(last);
        long lastTime = cal.getTimeInMillis();
        Integer date= Integer.parseInt(String.valueOf((lastTime-firstTime)/(1000*3600*24)));
        return date;
    }
    //获取员工编码
    public String getCode(Long id){

     // Staff user = getStaffByAuthToken(authToken);
        StoreManagement store = storeService.findById(id);
        Long count = staffDao.findCount(id);
        String code="0000";
        if(count>0 && count <= 9){
             code = store.getCode()+"000"+count;
        }else  if(count>=10 && count <=99){
            code = store.getCode()+"00"+count;
        }else  if(count>=100 && count <=999){
            code = store.getCode()+"0"+count;
        }else {
            code = store.getCode()+""+count;
        }
            return code;
    }

    public StaffListJson findById(Long id){

        Staff s = staffDao.findById(id);
        StaffListJson json = new StaffListJson(s);
        return json;
    }

    public Staff getId(Long id){
        return staffDao.findById(id);
    }

    public int quit(QuitJson data) {
        Staff s = staffDao.findById(data.getId());
        s.setEnable(false);
        s.setReason(data.getReason());
        s.setTurnoverTime(DatetimeUtil.parseDate(data.getQuitTime()));
        staffDao.updateObject(s);
        int c=1;
        return c;
    }

    /**
     * 离职员工列表
     * @param authToken
     * @param name
     * @param page
     * @param pageSize
     * @return
     */
    public ResultsWrapper<StaffListJson> findQuitList(String authToken, String name, Integer page, Integer pageSize) {
        Staff user = getStaffByAuthToken(authToken);
        List<Staff> staffs = staffDao.findQuitList(user.getStoreId(),name,page,pageSize);
        List<StaffListJson> json = new ArrayList<StaffListJson>();
        if (staffs.size()>0) {
            staffs.forEach(a ->json.add(new StaffListJson(a)));
        }
        Long count = staffDao.findQuitCount(user.getStoreId(),name);
        ResultsWrapper<StaffListJson> h = new ResultsWrapper<StaffListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));

        return  h;
    }


    public List<StaffListJson> findAllUser(String authToken) {
        Staff user = getStaffByAuthToken(authToken);
        List<Staff> staffs = staffDao.findAllUser(user.getStoreId());
        List<StaffListJson> json = new ArrayList<StaffListJson>();
        if (staffs.size()>0) {
            staffs.forEach(a ->json.add(new StaffListJson(a)));
        }
        return json;
    }

    public Staff findStoreByPhone(String phoneNumber) {

        return staffDao.findStoreByPhone(phoneNumber);
    }

    public int editPassword(String authToken, String password) {
        Staff user = getStaffByAuthToken(authToken);
        user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword(password));
        staffDao.updateObject(user);
        return 1;
    }

    public void logout(String authToken) {
        StaffSession session = staffDao.findAdminUserSessionByAuthToken(authToken);
        if (session != null) {
            session.setExpired(true);
            staffDao.updateObject(session);
        }
    }
    @Resource
    private ServiceOrdersService serviceOrdersService;

    @Resource
    private StoreService storeService;
    @Resource
    private StaffManyCustomerService staffManyCustomerService;
    public List<StaffListJson> findStaff(Long storeId, Long id, Long staffId) {
        StoreManagement storeManagement = storeService.findById(storeId);
        String guizhe = storeManagement.getAdvisorDesignation();
        String[] chars = guizhe.split(",");
        List<Staff> staffs = new ArrayList<>();
        for(String c:chars){
            switch (c){
                case "1":staffs.add(findByStall(id, storeId, 0));break;
                case "2":staffs.add(findFirstStall(id, storeId));break;
                case "3":staffs.add(findMaxService(id, storeId));break;
                case "4":staffs.add(findByStall(staffId, storeId, 1));break;
            }
        }
        staffs.removeAll(Collections.singleton(null));
        String ids = "";

        for(Staff s:staffs){
            ids += s.getId()+",";
        }
        ids = ids.substring(0, ids.length()-1);
        List<Staff> sta = staffDao.findByStallNotIds(ids, storeId );
        staffs.addAll(sta);
        List<StaffListJson> json = new ArrayList<StaffListJson>();
        if (staffs.size()>0) {
            staffs.forEach(a ->json.add(new StaffListJson(a)));
        }
        return json;
    }
    //用户指定技师
    public Staff findByStall(Long id, Long storeId, Integer type){
        if(id==null){return null;}
        StaffManyCustomer s = staffManyCustomerService.findByCustomer(id, storeId, type);
        if(s!=null) {
            Staff sta = staffDao.findById(s.getStaffId());
            return sta;
        }
        return null;
    }
    //上一次服务者
    public Staff findFirstStall(Long id, Long storeId){
        ServiceOrders serviceOrders = serviceOrdersService.findLastService(id, storeId);
        if(serviceOrders!=null) {
            Staff sta = staffDao.findById(serviceOrders.getOperatorId());
            return sta;
        }
        return null;
    }
    //服务次数最多者
    public Staff findMaxService(Long id, Long storeId){
        Staff sta = staffDao.findById(serviceOrdersService.findMaxTime( storeId));
        return sta;
    }

    public List<Staff> findStoreId(Long storeId) {
        List<Staff> staffs = staffDao.findAllUser(storeId);
        return staffs;
    }


}
