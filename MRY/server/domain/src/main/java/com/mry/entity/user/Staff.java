package com.mry.entity.user;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by kaik on 2017/10/18.
 * 员工管理
 */
@Entity
@Table(name = Staff.TABLE_NAME)
public class Staff extends BaseEntity {

    public static final String TABLE_NAME = "staff";

    //注册店
    @Column(name = "store_name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //帐号
    @Column(name = "account")
    private String account;

    //帐号
    @Column(name = "password")
    private String password;

    //姓名
    @Column(name = "real_name")
    private String realName;

    //员工编码
    @Column(name = "code")
    private String code;

    //电话
    @Column(name = "phone_number")
    private String phoneNumber;

    //生日
    @Column(name = "birthday")
    private Date birthday;

    //性别
    @Column(name = "gender")
    private String gender;

    //身份证
    @Column(name = "id_card_number")
    private String idCardNumber;

    //籍贯
    @Column(name = "place_of_origin")
    private String placeOfOrigin;

    //现住地地址
    @Column(name = "address")
    private String address;
 //   Age(读的时候算)				年龄

    //邮箱
    @Column(name = "email")
    private String email;

    //头像
    @Column(name = "icon_url")
    private String iconUrl;

    //服务介绍
    @Column(name = "service_introduction")
    private String serviceIntroduction;

    //入职时间
    @Column(name = "entry_time")
    private Date entryTime;

    //等级
    @Column(name = "grade")
    private String grade;

    //等级
    @Column(name = "grade_id")
    private Long gradeId;

    //工作状态（0：空闲；1：忙碌；2：请假）
    @Column(name = "status")
    private String status;

    //工作理由
    @Column(name = "reason_for_leave")
    private String reasonForLeave;

    //是否离职
    @Column(name = "is_enable")
    private Boolean isEnable;

    //离职原因
    @Column(name = "reason")
    private String reason;

    //离职时间
    @Column(name = "turnover_time")
    private Date turnoverTime;

    //角色职位
    @Column(name = "role_name")
    private String roleName;

    //角色id
    @Column(name = "role_id")
    private Long roleId;

    //角色职位
    @Column(name = "group_name")
    private String groupName;

    //角色id
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    //是否系统员工
    @Column(name = "is_system")
    private Boolean isSystem;

    //登录次数
    @Column(name = "longin_count")
    private Integer loginCount=0;

    //随机验证码
    @Column(name = "verification")
    private String verification;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getTurnoverTime() {
        return turnoverTime;
    }

    public void setTurnoverTime(Date turnoverTime) {
        this.turnoverTime = turnoverTime;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Boolean getSystem() {
        return isSystem;
    }

    public void setSystem(Boolean system) {
        isSystem = system;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }
}
