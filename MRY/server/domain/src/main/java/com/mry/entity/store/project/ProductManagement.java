package com.mry.entity.store.project;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by kaik on 2017/12/1.
 */
@Entity
@Table(name = ProductManagement.TABLE_NAME)
public class ProductManagement extends BaseEntity {

    public static final String TABLE_NAME = "product_management";


    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //名字
    @Column(name = "product_name")
    private String productName;


    //现金金额
    @Column(name = "cash_money")
    private BigDecimal cashMoney;
    //疗程金额
    @Column(name = "course_money")
    private BigDecimal courseMoney;
    //卡扣金额
    @Column(name = "buckle_money")
    private BigDecimal buckleMoney;
    //体验金额
    @Column(name = "experience_money")
    private BigDecimal experienceMoney;


    //编号
    @Column(name = "code")
    private String code;

    //介绍
    @Column(name = "introduce")
    private String introduce;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getCashMoney() {
        return cashMoney;
    }

    public void setCashMoney(BigDecimal cashMoney) {
        this.cashMoney = cashMoney;
    }

    public BigDecimal getCourseMoney() {
        return courseMoney;
    }

    public void setCourseMoney(BigDecimal courseMoney) {
        this.courseMoney = courseMoney;
    }

    public BigDecimal getBuckleMoney() {
        return buckleMoney;
    }

    public void setBuckleMoney(BigDecimal buckleMoney) {
        this.buckleMoney = buckleMoney;
    }

    public BigDecimal getExperienceMoney() {
        return experienceMoney;
    }

    public void setExperienceMoney(BigDecimal experienceMoney) {
        this.experienceMoney = experienceMoney;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
