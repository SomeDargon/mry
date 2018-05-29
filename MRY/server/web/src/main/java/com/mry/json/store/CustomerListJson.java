package com.mry.json.store;

import com.mry.entity.user.Customer;
import com.mry.util.DatetimeUtil;

import java.math.BigDecimal;

/**
 * Created by kaik on 2017/11/23.
 */
public class CustomerListJson {

        private Long id;
        //真实姓名
        private String realName;
        //电话
        private String phoneNumber;
        //性别
        private String gender;
        //身份证号
        private String idCardNumber;
        //生日
        private String birthday;

        //age
        private String age;

        //会员等级
        private String level;

        // 会员积分
        private String integral;

        // 介绍人
        private String introducer;
        // 介绍人
        private Long introducerId;

        //注册店
        private String storeName;

        //注册店Id
        private Long storeId;

        //注册时间
        private String registrationTime;

        //储蓄卡金额
        private BigDecimal money;
        // 操作人
        private String createPerson;

        // 操作人
        private Long createId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

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

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
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

        public BigDecimal getMoney() {
            return money;
        }

        public void setMoney(BigDecimal money) {
            this.money = money;
        }


        public String getCreatePerson() {
            return createPerson;
        }

        public void setCreatePerson(String createPerson) {
            this.createPerson = createPerson;
        }

        public Long getIntroducerId() {
            return introducerId;
        }

        public void setIntroducerId(Long introducerId) {
            this.introducerId = introducerId;
        }

        public Long getCreateId() {
            return createId;
        }

        public void setCreateId(Long createId) {
            this.createId = createId;
        }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public CustomerListJson(Customer data) {
            this.id = data.getId();
            this.realName = data.getRealName();
            this.phoneNumber = data.getPhoneNumber();
            this.gender = data.getGender();
            this.idCardNumber = data.getIdCardNumber();
            this.birthday = DatetimeUtil.formatDate(data.getBirthday());
            this.level = data.getLevel();
            this.integral = data.getIntegral();
            this.introducer = data.getIntroducer();
            this.introducerId = data.getIntroducerId();
            this.storeName = data.getStoreName();
            this.storeId = data.getStoreId();
            this.registrationTime = data.getRegistrationTime();
            this.money = data.getMoney();
            this.createPerson = data.getRealName();
            this.createId = data.getId();
            this.age =String.valueOf(DatetimeUtil.getNewAge(data.getIdCardNumber()));

        }

}
