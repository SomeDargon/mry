package com.mry.entity.system;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2018/1/16.
 * 店长月报表
 */
@ApiModel(value="店长月报表",description="店长月报表")
@Entity
@Table(name = ManagerOfTheMonthlyReport.TABLE_NAME)
public class ManagerOfTheMonthlyReport extends BaseEntity {

    public static final String TABLE_NAME = "manager_of_the_monthly_report";

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    @Column(name = "store_id")
    private Long storeId;

    //日期
    @ApiModelProperty(value="日期",name="dateTime")
    @Column(name = "date_time")
    private Boolean dateTime=true;

    //全店业绩
    @ApiModelProperty(value="全店业绩",name="shopPerformance")
    @Column(name = "shop_performance")
    private Boolean shopPerformance=true;

    //全店客流
    @ApiModelProperty(value="全店客流",name="shopPassenger")
    @Column(name = "shop_passenger")
    private Boolean shopPassenger=true;

//    //全店业绩
//    @ApiModelProperty(value="全店业绩",name="personalformance")
//    @Column(name = "personal_performance")
//    private Boolean personalformance=true;

    //卡扣产品
    @ApiModelProperty(value="卡扣产品",name="product")
    @Column(name = "product")
    private Boolean product=true;

    //全店到店人数
    @ApiModelProperty(value="全店到店人数",name="fullStoreNumber")
    @Column(name = "full_store_number")
    private Boolean fullStoreNumber=true;

    //全店实操
    @ApiModelProperty(value="全店实操",name="fullShopPractice")
    @Column(name = "full_shop_practice")
    private Boolean fullShopPractice=true;

    //卡扣项目
    @ApiModelProperty(value="卡扣项目",name="buckleProject")
    @Column(name = "buckle_project")
    private Boolean buckleProject=true;


    //高端项目
    @ApiModelProperty(value="高端项目",name="highEndProject")
    @Column(name = "high_end_project")
    private Boolean highEndProject=true;

    //是否记录店长
    @ApiModelProperty(value="是否记录店长",name="highEndProject")
    @Column(name = "record_the_store_manager")
    private Boolean recordTheStoreManager=true;


    //备注
    @ApiModelProperty(value="备注",name="remarks")
    @Column(name = "remarks")
    private Boolean remarks=true;

    //是否启用
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

    public Boolean getDateTime() {
        return dateTime;
    }

    public void setDateTime(Boolean dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getShopPerformance() {
        return shopPerformance;
    }

    public void setShopPerformance(Boolean shopPerformance) {
        this.shopPerformance = shopPerformance;
    }

    public Boolean getShopPassenger() {
        return shopPassenger;
    }

    public void setShopPassenger(Boolean shopPassenger) {
        this.shopPassenger = shopPassenger;
    }

    public Boolean getProduct() {
        return product;
    }

    public void setProduct(Boolean product) {
        this.product = product;
    }

    public Boolean getBuckleProject() {
        return buckleProject;
    }

    public void setBuckleProject(Boolean buckleProject) {
        this.buckleProject = buckleProject;
    }

    public Boolean getHighEndProject() {
        return highEndProject;
    }

    public void setHighEndProject(Boolean highEndProject) {
        this.highEndProject = highEndProject;
    }

    public Boolean getRemarks() {
        return remarks;
    }

    public void setRemarks(Boolean remarks) {
        this.remarks = remarks;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Boolean getFullStoreNumber() {
        return fullStoreNumber;
    }

    public void setFullStoreNumber(Boolean fullStoreNumber) {
        this.fullStoreNumber = fullStoreNumber;
    }

    public Boolean getFullShopPractice() {
        return fullShopPractice;
    }

    public void setFullShopPractice(Boolean fullShopPractice) {
        this.fullShopPractice = fullShopPractice;
    }

    public Boolean getRecordTheStoreManager() {
        return recordTheStoreManager;
    }

    public void setRecordTheStoreManager(Boolean recordTheStoreManager) {
        this.recordTheStoreManager = recordTheStoreManager;
    }
}
