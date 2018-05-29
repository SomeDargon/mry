package com.mry.entity.system;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2018/1/16.
 * 顾问月报表
 */
@ApiModel(value="顾问月报表",description="顾问月报表")
@Entity
@Table(name = ConsultantMonthlyReport.TABLE_NAME)
public class ConsultantMonthlyReport  extends BaseEntity {

    public static final String TABLE_NAME = "consultant_monthly_report";

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

    //到店人数
    @ApiModelProperty(value="到店人数",name="storeNumber")
    @Column(name = "store_number")
    private Boolean storeNumber=true;

    //首次到店人数
    @ApiModelProperty(value="首次到店人数",name="firstStoreNumber")
    @Column(name = "first_store_number")
    private Boolean firstStoreNumber=true;

    //二次成交人数
    @ApiModelProperty(value="二次成交人数",name="twoTurnover")
    @Column(name = "two_turnover")
    private Boolean twoTurnover=true;

    //首次成交人数
    @ApiModelProperty(value="首次成交人数",name="firstTransactionNumber")
    @Column(name = "first_transaction_number")
    private Boolean firstTransactionNumber=true;

    //实操总额
    @ApiModelProperty(value="实操总额",name="totalActualExercise")
    @Column(name = "total_actual_exercise")
    private Boolean totalActualExercise=true;


    //客单价
    @ApiModelProperty(value="客单价",name="unitPrice")
    @Column(name = "unit_price")
    private Boolean unitPrice=true;

    //客流
    @ApiModelProperty(value="客流",name="passenger")
    @Column(name = "passenger")
    private Boolean passenger=true;

    //个人业绩
    @ApiModelProperty(value="个人业绩",name="personalPerformance")
    @Column(name = "personal_performance")
    private Boolean personalPerformance=true;

    //会员储值
    @ApiModelProperty(value="会员储值",name="memberStorageValue")
    @Column(name = "member_storage_value")
    private Boolean memberStorageValue=true;

    //售前
    @ApiModelProperty(value="售前",name="preSale")
    @Column(name = "pre_sale")
    private Boolean preSale=true;

    //售后
    @ApiModelProperty(value="售后",name="aftermarket")
    @Column(name = "aftermarket")
    private Boolean aftermarket=true;

    //美容
    @ApiModelProperty(value="美容",name="beauty")
    @Column(name = "beauty")
    private Boolean beauty=true;

    //美容现金
    @ApiModelProperty(value="美容现金",name="beautyCash")
    @Column(name = "beauty_cash")
    private Boolean beautyCash=true;

    //美容实操
    @ApiModelProperty(value="美容实操",name="beautyPractice")
    @Column(name = "beauty_practice")
    private Boolean beautyPractice=true;

    //美发
    @ApiModelProperty(value="美发",name="hairdressing")
    @Column(name = "hairdressing")
    private Boolean hairdressing=true;

    //美发现金
    @ApiModelProperty(value="美发现金",name="hairdressingCash")
    @Column(name = "hairdressingy_cash")
    private Boolean hairdressingCash=true;

    //美发卡扣
    @ApiModelProperty(value="美发卡扣",name="hairdressingSnap")
    @Column(name = "hairdressing_snap")
    private Boolean hairdressingSnap=true;

    //瑜伽
    @ApiModelProperty(value="瑜伽",name="yoga")
    @Column(name = "yoga")
    private Boolean yoga=true;

    //瑜伽现金
    @ApiModelProperty(value="瑜伽现金",name="yogaCash")
    @Column(name = "yoga_cash")
    private Boolean yogaCash=true;

    //瑜伽卡扣
    @ApiModelProperty(value="瑜伽卡扣",name="yogaSnap")
    @Column(name = "yoga_snap")
    private Boolean yogaSnap=true;

    //产品
    @ApiModelProperty(value="产品",name="product")
    @Column(name = "product")
    private Boolean product=true;

    //产品现金
    @ApiModelProperty(value="产品现金",name="productCash")
    @Column(name = "product_cash")
    private Boolean productCash=true;

    //产品卡扣
    @ApiModelProperty(value="产品卡扣",name="productSnap")
    @Column(name = "product_snap")
    private Boolean productSnap=true;

    //欠款
    @ApiModelProperty(value="欠款",name="arrears")
    @Column(name = "arrears")
    private Boolean arrears=true;

    //高端项目
    @ApiModelProperty(value="高端项目",name="highEndProjects")
    @Column(name = "high_end_projects")
    private Boolean highEndProjects=true;

    //项目现金
    @ApiModelProperty(value="项目现金",name="projectCash")
    @Column(name = "project_cash")
    private Boolean projectCash=true;

    //项目卡扣消耗
    @ApiModelProperty(value="项目卡扣消耗",name="projectSnap")
    @Column(name = "project_snap")
    private Boolean projectSnap=true;

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

    public Boolean getPassenger() {
        return passenger;
    }

    public void setPassenger(Boolean passenger) {
        this.passenger = passenger;
    }

    public Boolean getPersonalPerformance() {
        return personalPerformance;
    }

    public void setPersonalPerformance(Boolean personalPerformance) {
        this.personalPerformance = personalPerformance;
    }

    public Boolean getMemberStorageValue() {
        return memberStorageValue;
    }

    public void setMemberStorageValue(Boolean memberStorageValue) {
        this.memberStorageValue = memberStorageValue;
    }

    public Boolean getPreSale() {
        return preSale;
    }

    public void setPreSale(Boolean preSale) {
        this.preSale = preSale;
    }

    public Boolean getAftermarket() {
        return aftermarket;
    }

    public void setAftermarket(Boolean aftermarket) {
        this.aftermarket = aftermarket;
    }

    public Boolean getBeauty() {
        return beauty;
    }

    public void setBeauty(Boolean beauty) {
        this.beauty = beauty;
    }

    public Boolean getBeautyCash() {
        return beautyCash;
    }

    public void setBeautyCash(Boolean beautyCash) {
        this.beautyCash = beautyCash;
    }

    public Boolean getBeautyPractice() {
        return beautyPractice;
    }

    public void setBeautyPractice(Boolean beautyPractice) {
        this.beautyPractice = beautyPractice;
    }

    public Boolean getHairdressing() {
        return hairdressing;
    }

    public void setHairdressing(Boolean hairdressing) {
        this.hairdressing = hairdressing;
    }

    public Boolean getHairdressingCash() {
        return hairdressingCash;
    }

    public void setHairdressingCash(Boolean hairdressingCash) {
        this.hairdressingCash = hairdressingCash;
    }

    public Boolean getHairdressingSnap() {
        return hairdressingSnap;
    }

    public void setHairdressingSnap(Boolean hairdressingSnap) {
        this.hairdressingSnap = hairdressingSnap;
    }

    public Boolean getYoga() {
        return yoga;
    }

    public void setYoga(Boolean yoga) {
        this.yoga = yoga;
    }

    public Boolean getYogaCash() {
        return yogaCash;
    }

    public void setYogaCash(Boolean yogaCash) {
        this.yogaCash = yogaCash;
    }

    public Boolean getYogaSnap() {
        return yogaSnap;
    }

    public void setYogaSnap(Boolean yogaSnap) {
        this.yogaSnap = yogaSnap;
    }

    public Boolean getProduct() {
        return product;
    }

    public void setProduct(Boolean product) {
        this.product = product;
    }

    public Boolean getProductCash() {
        return productCash;
    }

    public void setProductCash(Boolean productCash) {
        this.productCash = productCash;
    }

    public Boolean getProductSnap() {
        return productSnap;
    }

    public void setProductSnap(Boolean productSnap) {
        this.productSnap = productSnap;
    }

    public Boolean getArrears() {
        return arrears;
    }

    public void setArrears(Boolean arrears) {
        this.arrears = arrears;
    }

    public Boolean getHighEndProjects() {
        return highEndProjects;
    }

    public void setHighEndProjects(Boolean highEndProjects) {
        this.highEndProjects = highEndProjects;
    }

    public Boolean getProjectCash() {
        return projectCash;
    }

    public void setProjectCash(Boolean projectCash) {
        this.projectCash = projectCash;
    }

    public Boolean getProjectSnap() {
        return projectSnap;
    }

    public void setProjectSnap(Boolean projectSnap) {
        this.projectSnap = projectSnap;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Boolean getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Boolean storeNumber) {
        this.storeNumber = storeNumber;
    }

    public Boolean getFirstStoreNumber() {
        return firstStoreNumber;
    }

    public void setFirstStoreNumber(Boolean firstStoreNumber) {
        this.firstStoreNumber = firstStoreNumber;
    }

    public Boolean getTwoTurnover() {
        return twoTurnover;
    }

    public void setTwoTurnover(Boolean twoTurnover) {
        this.twoTurnover = twoTurnover;
    }

    public Boolean getFirstTransactionNumber() {
        return firstTransactionNumber;
    }

    public void setFirstTransactionNumber(Boolean firstTransactionNumber) {
        this.firstTransactionNumber = firstTransactionNumber;
    }

    public Boolean getTotalActualExercise() {
        return totalActualExercise;
    }

    public void setTotalActualExercise(Boolean totalActualExercise) {
        this.totalActualExercise = totalActualExercise;
    }

    public Boolean getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Boolean unitPrice) {
        this.unitPrice = unitPrice;
    }
}
