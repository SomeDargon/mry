package com.mry.entity.store.salary;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2018/1/18.
 */
@ApiModel(value="业绩提成",description="业绩提成")
@Entity
@Table(name = PerformanceDrawing.TABLE_NAME)
public class PerformanceDrawing extends BaseEntity {

    public static final String TABLE_NAME = "performance_drawing";

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    @Column(name = "store_id")
    private Long storeId;

    //低限
    @ApiModelProperty(value="低限",name="lowLimit")
    @Column(name = "low_limit")
    private String lowLimit;

    //高限
    @ApiModelProperty(value="高限",name="highLimit")
    @Column(name = "high_limit")
    private String highLimit;

//    //卡项销售
//    @ApiModelProperty(value="卡项销售",name="cardSales")
//    @Column(name = "card_sales")
//    private String cardSales;


    //储值
    @ApiModelProperty(value="储值",name="storedValue")
    @Column(name = "stored_value")
    private String storedValue;

    //现金疗程
    @ApiModelProperty(value="现金疗程",name="cashCourse")
    @Column(name = "cash_course")
    private String cashCourse;

    //现金产品
    @ApiModelProperty(value="现金疗程",name="cashProduct")
    @Column(name = "cash_product")
    private String cashProduct;

    //卡扣疗程
    @ApiModelProperty(value="卡扣疗程",name="buckleCourse")
    @Column(name = "buckle_course")
    private String buckleCourse;

    //卡扣产品
    @ApiModelProperty(value="卡扣产品",name="buckleProduct")
    @Column(name = "buckle_product")
    private String buckleProduct;

    //超折产品
    @ApiModelProperty(value="超折产品",name="superProduct")
    @Column(name = "super_product ")
    private String superProduct ;

    //其他
    @ApiModelProperty(value="其他",name="otherProduct")
    @Column(name = "other_product")
    private String otherProduct;


    //高端项目
    @ApiModelProperty(value="高端项目",name="highEndProject")
    @Column(name = "high_end_project")
    private String highEndProject;

    //是否启用
    @ApiModelProperty(value="是否启用",name="disable")
    @Column(name = "disable")
    private Boolean disable;

    //是否注销
    @ApiModelProperty(value="是否注销",name="isEnable")
    @Column(name = "is_enable")
    private Boolean isEnable;

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

    public String getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(String lowLimit) {
        this.lowLimit = lowLimit;
    }

    public String getHighLimit() {
        return highLimit;
    }

    public void setHighLimit(String highLimit) {
        this.highLimit = highLimit;
    }



    public String getBuckleProduct() {
        return buckleProduct;
    }

    public void setBuckleProduct(String buckleProduct) {
        this.buckleProduct = buckleProduct;
    }

    public String getHighEndProject() {
        return highEndProject;
    }

    public void setHighEndProject(String highEndProject) {
        this.highEndProject = highEndProject;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getStoredValue() {
        return storedValue;
    }

    public void setStoredValue(String storedValue) {
        this.storedValue = storedValue;
    }

    public String getCashCourse() {
        return cashCourse;
    }

    public void setCashCourse(String cashCourse) {
        this.cashCourse = cashCourse;
    }

    public String getCashProduct() {
        return cashProduct;
    }

    public void setCashProduct(String cashProduct) {
        this.cashProduct = cashProduct;
    }

    public String getBuckleCourse() {
        return buckleCourse;
    }

    public void setBuckleCourse(String buckleCourse) {
        this.buckleCourse = buckleCourse;
    }

    public String getSuperProduct() {
        return superProduct;
    }

    public void setSuperProduct(String superProduct) {
        this.superProduct = superProduct;
    }

    public String getOtherProduct() {
        return otherProduct;
    }

    public void setOtherProduct(String otherProduct) {
        this.otherProduct = otherProduct;
    }


}
