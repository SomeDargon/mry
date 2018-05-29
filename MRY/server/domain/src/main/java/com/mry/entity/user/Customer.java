package com.mry.entity.user;


import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kaik on 2017/8/18.
 * 顾客管理
 */
@Entity
@Table(name = Customer.TABLE_NAME)
public class Customer extends BaseEntity {

    public static final String TABLE_NAME = "customer";


    //真实姓名
    @Column(name = "real_name")
    private String realName;
    //电话
    @Column(name = "phone_number")
    private String phoneNumber;
    //性别
    @Column(name = "gender")
    private String gender;
    //身份证号
    @Column(name = "id_card_number")
    private String idCardNumber;
    //生日
    @Column(name = "birthday")
    private Date birthday;

    //会员等级
    @Column(name = "level")
    private String level;

    // 会员积分
    @Column(name = "integral")
    private String integral;

    // 介绍人
    @Column(name = "introducer")
    private String introducer;

    // 介绍人
    @Column(name = "introducer_id")
    private Long introducerId;

    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //注册时间
    @Column(name = "registration_time")
    private String registrationTime;


    //储蓄卡金额
    @Column(name = "money")
    private BigDecimal money;

    // 操作人
    @Column(name = "create_person")
    private String createPerson;

    // 操作人
    @Column(name = "create_id")
    private Long createId;


    //是否储值会员
    @Column(name = "is_stored_value")
    private Boolean isStoredValue;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getIntroducer() {
        return introducer;
    }

    public void setIntroducer(String introducer) {
        this.introducer = introducer;
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

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Long getIntroducerId() {
        return introducerId;
    }

    public void setIntroducerId(Long introducerId) {
        this.introducerId = introducerId;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Boolean getStoredValue() {
        return isStoredValue;
    }

    public void setStoredValue(Boolean storedValue) {
        isStoredValue = storedValue;
    }
}
