package com.mry.entity.system;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaikI on 2018/1/16.
 * 美容师月报表
 */
@ApiModel(value="美容师月报表",description="美容师月报表")
@Entity
@Table(name = BeauticianMonthlyReport.TABLE_NAME)
public class BeauticianMonthlyReport extends BaseEntity {

    public static final String TABLE_NAME = "beautician_monthly_report";

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

    //客流
    @ApiModelProperty(value="客流",name="passenger")
    @Column(name = "passenger")
    private Boolean passenger=true;

    //储存业绩
    @ApiModelProperty(value="储存业绩",name="storagePerformance")
    @Column(name = "storage_performance")
    private Boolean storagePerformance=true;

    //现金疗程
    @ApiModelProperty(value="现金疗程",name="cashCourse")
    @Column(name = "cash_course")
    private Boolean cashCourse=true;

    //卡业绩
    @ApiModelProperty(value="卡业绩",name="cardPerformance")
    @Column(name = "card_performance")
    private Boolean cardPerformance=true;

    //面部实操
    @ApiModelProperty(value="面部实操",name="facialPractice")
    @Column(name = "facial_practice")
    private Boolean facialPractice=true;

    //面部实操 指定
    @ApiModelProperty(value="面部实操指定",name="facialPracticeAppoint")
    @Column(name = "facial_practice_appoint")
    private Boolean facialPracticeAppoint=true;

    //面部实操非指定
    @ApiModelProperty(value="面部实操非指定",name="facialPracticeNonSpecifiedt")
    @Column(name = "facial_practice_non_specified")
    private Boolean facialPracticeNonSpecifiedt=true;

    //身体实操
    @ApiModelProperty(value="身体实操",name="physicalExercise")
    @Column(name = "physical_exercise")
    private Boolean physicalExercise=true;

    //面部实操 指定
    @ApiModelProperty(value="身体实操指定",name="physicalExerciseAppoint")
    @Column(name = "physical_exercise_appoint")
    private Boolean physicalExerciseAppoint=true;

    //面部实操非指定
    @ApiModelProperty(value="身体实操非指定",name="physicalExerciseNonSpecifiedt")
    @Column(name = "physical_exercise_non_specified")
    private Boolean physicalExerciseNonSpecifiedt=true;

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

    //赠送手工
    @ApiModelProperty(value="赠送手工",name="giveHandToHand")
    @Column(name = "give_hand_to_hand")
    private Boolean giveHandToHand=true;

    //转介绍业绩
    @ApiModelProperty(value="转介绍业绩",name="introducePerformance")
    @Column(name = "introduce_performance")
    private Boolean introducePerformance=true;

    //高端项目
    @ApiModelProperty(value="高端项目",name="highEndProjects")
    @Column(name = "high_end_projects")
    private Boolean highEndProjects=true;

    //项目现金
    @ApiModelProperty(value="项目现金",name="projectCash")
    @Column(name = "project_cash")
    private Boolean projectCash=true;

    //项目卡扣
    @ApiModelProperty(value="项目卡扣",name="projectSnap")
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

    public Boolean getStoragePerformance() {
        return storagePerformance;
    }

    public void setStoragePerformance(Boolean storagePerformance) {
        this.storagePerformance = storagePerformance;
    }

    public Boolean getCashCourse() {
        return cashCourse;
    }

    public void setCashCourse(Boolean cashCourse) {
        this.cashCourse = cashCourse;
    }

    public Boolean getFacialPractice() {
        return facialPractice;
    }

    public void setFacialPractice(Boolean facialPractice) {
        this.facialPractice = facialPractice;
    }

    public Boolean getFacialPracticeAppoint() {
        return facialPracticeAppoint;
    }

    public void setFacialPracticeAppoint(Boolean facialPracticeAppoint) {
        this.facialPracticeAppoint = facialPracticeAppoint;
    }

    public Boolean getFacialPracticeNonSpecifiedt() {
        return facialPracticeNonSpecifiedt;
    }

    public void setFacialPracticeNonSpecifiedt(Boolean facialPracticeNonSpecifiedt) {
        this.facialPracticeNonSpecifiedt = facialPracticeNonSpecifiedt;
    }

    public Boolean getPhysicalExercise() {
        return physicalExercise;
    }

    public void setPhysicalExercise(Boolean physicalExercise) {
        this.physicalExercise = physicalExercise;
    }

    public Boolean getPhysicalExerciseAppoint() {
        return physicalExerciseAppoint;
    }

    public void setPhysicalExerciseAppoint(Boolean physicalExerciseAppoint) {
        this.physicalExerciseAppoint = physicalExerciseAppoint;
    }

    public Boolean getPhysicalExerciseNonSpecifiedt() {
        return physicalExerciseNonSpecifiedt;
    }

    public void setPhysicalExerciseNonSpecifiedt(Boolean physicalExerciseNonSpecifiedt) {
        this.physicalExerciseNonSpecifiedt = physicalExerciseNonSpecifiedt;
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

    public Boolean getGiveHandToHand() {
        return giveHandToHand;
    }

    public void setGiveHandToHand(Boolean giveHandToHand) {
        this.giveHandToHand = giveHandToHand;
    }

    public Boolean getIntroducePerformance() {
        return introducePerformance;
    }

    public void setIntroducePerformance(Boolean introducePerformance) {
        this.introducePerformance = introducePerformance;
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

    public Boolean getCardPerformance() {
        return cardPerformance;
    }

    public void setCardPerformance(Boolean cardPerformance) {
        this.cardPerformance = cardPerformance;
    }
}
