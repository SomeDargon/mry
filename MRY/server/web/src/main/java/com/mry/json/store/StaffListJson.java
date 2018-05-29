package com.mry.json.store;

import com.mry.entity.user.Staff;
import com.mry.exception.BusinessException;
import com.mry.exception.ErrorCode;
import com.mry.util.DatetimeUtil;

/**
 * Created by kaik on 2017/10/30.
 */
public class StaffListJson {

    private Long id;

    //注册店
    private String storeName;

    //注册店Id
    private Long storeId;

    //帐号
    private String account;

    //姓名
    private String realName;

    //员工编码
    private String code;

    //电话
    private String phoneNumber;

    //生日
    private String birthday;

    //性别
    private String gender;

    //身份证
    private String idCardNumber;

    //籍贯
    private String placeOfOrigin;

    //现住地地址
    private String address;
    // 	年龄
    private String age;

    //邮箱
    private String email;

    //头像
    private String iconUrl;

    //服务介绍
    private String serviceIntroduction;

    //入职时间
    private String entryTime;

    //等级
    private String grade;

    //等级
    private Long gradeId;

    //工作状态（0：空闲；1：忙碌；2：请假）
    private String status;

    //工作理由
    private String reasonForLeave;

    //是否离职
    private Boolean isEnable;

    //离职原因
    private String reason;

    //角色职位
    private String roleName;

    //离职时间
    private String turnoverTime;

    //角色id
    private Long roleId;

    //小组
    private String groupName;

    //小组id
    private Long groupId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getServiceIntroduction() {
        return serviceIntroduction;
    }

    public void setServiceIntroduction(String serviceIntroduction) {
        this.serviceIntroduction = serviceIntroduction;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReasonForLeave() {
        return reasonForLeave;
    }

    public void setReasonForLeave(String reasonForLeave) {
        this.reasonForLeave = reasonForLeave;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getTurnoverTime() {
        return turnoverTime;
    }

    public void setTurnoverTime(String turnoverTime) {
        this.turnoverTime = turnoverTime;
    }

    public StaffListJson(Staff data){
        this.id = data.getId();
        this.storeName = data.getStoreName();
        this.storeId = data.getStoreId();
        this.account = data.getAccount();
        this.realName = data.getRealName();
        this.code = data.getCode();
        this.phoneNumber = data.getPhoneNumber();
        this.birthday = DatetimeUtil.formatDate(data.getBirthday());
        this.gender = data.getGender();
        this.idCardNumber = data.getIdCardNumber();
        this.placeOfOrigin = data.getPlaceOfOrigin();
        this.address = data.getAddress();
        this.age = String.valueOf(DatetimeUtil.getNewAge(data.getIdCardNumber()));
        this.email = data.getEmail();
        this.iconUrl = data.getIconUrl();
        this.serviceIntroduction = data.getServiceIntroduction();
        this.entryTime = DatetimeUtil.formatDate(data.getEntryTime());
        this.grade = data.getGrade();
        this.gradeId = data.getGradeId();
        this.status = data.getStatus();
        this.reasonForLeave = data.getReasonForLeave();
        this.isEnable = data.getEnable();
        this.reason = data.getReason();
        this.roleName = data.getRoleName();
        this.roleId = data.getRoleId();
        this.groupName = data.getGroupName();
        this.groupId = data.getGroupId();
        this.turnoverTime = DatetimeUtil.formatDate(data.getTurnoverTime());
    }
}
