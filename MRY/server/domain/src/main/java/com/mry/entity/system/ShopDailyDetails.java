package com.mry.entity.system;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2018/1/16.
 * 详细店日报
 */
@ApiModel(value="详细店日报",description="详细店日报")
@Entity
@Table(name = ShopDailyDetails.TABLE_NAME)
public class ShopDailyDetails extends BaseEntity {

    public static final String TABLE_NAME = "shop_daily_details";

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    @Column(name = "store_id")
    private Long storeId;

    //员工姓名
    @ApiModelProperty(value="员工姓名",name="employeeName")
    @Column(name = "employee_name")
    private Boolean employeeName=true;

    //顾客姓名
    @ApiModelProperty(value="顾客姓名",name="customerName")
    @Column(name = "customer_name")
    private Boolean customerName=true;

    //服务项目或产品
    @ApiModelProperty(value="服务项目或产品",name="serviceItems")
    @Column(name = "service_items")
    private Boolean serviceItems=true;

    //面部
    @ApiModelProperty(value="面部",name="facialPractice")
    @Column(name = "facial_practice")
    private Boolean facialPractice=true;

    //面部指定
    @ApiModelProperty(value="面部指定",name="facialPracticeAppoint")
    @Column(name = "facial_practice_appoint")
    private Boolean facialPracticeAppoint=true;

    //面部非指定
    @ApiModelProperty(value="面部非指定",name="facialPracticeNonSpecifiedt")
    @Column(name = "facial_practice_non_specified")
    private Boolean facialPracticeNonSpecifiedt=true;

    //身体
    @ApiModelProperty(value="身体",name="physicalExercise")
    @Column(name = "physical_exercise")
    private Boolean physicalExercise=true;

    //身体指定
    @ApiModelProperty(value="面部指定",name="physicalExerciseAppoint")
    @Column(name = "physical_exercise_appoint")
    private Boolean physicalExerciseAppoint=true;

    //身体非指定
    @ApiModelProperty(value="面部非指定",name="physicalExerciseNonSpecifiedt")
    @Column(name = "physical_exercise_non_specified")
    private Boolean physicalExerciseNonSpecifiedt=true;

    //现金业绩（不含产品）
    @ApiModelProperty(value="现金业绩（不含产品）",name="cashPerformance")
    private Boolean cashPerformance=true;

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

    //超折
    @ApiModelProperty(value="超折",name="superDiscount")
    @Column(name = "super_discount")
    private Boolean superDiscount=true;

    //卡扣疗程
    @ApiModelProperty(value="卡扣疗程",name="claspCourse")
    @Column(name = "clasp_course")
    private Boolean claspCourse=true;

    //卡扣疗程名称
    @ApiModelProperty(value="卡扣疗程名称",name="claspCourseName")
    @Column(name = "clasp_course_name")
    private Boolean claspCourseName=true;

    //卡扣疗程金额
    @ApiModelProperty(value="卡扣疗程金额",name="claspCourseMoney")
    @Column(name = "clasp_course_money")
    private Boolean claspCourseMoney=true;

    //高端项目
    @ApiModelProperty(value="高端项目",name="highEndProjects")
    @Column(name = "high_end_projects")
    private Boolean highEndProjects=true;

    //顾问
    @ApiModelProperty(value="顾问",name="adviser")
    @Column(name = "adviser")
    private Boolean adviser=true;

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

    public Boolean getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(Boolean employeeName) {
        this.employeeName = employeeName;
    }

    public Boolean getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Boolean customerName) {
        this.customerName = customerName;
    }

    public Boolean getServiceItems() {
        return serviceItems;
    }

    public void setServiceItems(Boolean serviceItems) {
        this.serviceItems = serviceItems;
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

    public Boolean getCashPerformance() {
        return cashPerformance;
    }

    public void setCashPerformance(Boolean cashPerformance) {
        this.cashPerformance = cashPerformance;
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

    public Boolean getSuperDiscount() {
        return superDiscount;
    }

    public void setSuperDiscount(Boolean superDiscount) {
        this.superDiscount = superDiscount;
    }

    public Boolean getClaspCourse() {
        return claspCourse;
    }

    public void setClaspCourse(Boolean claspCourse) {
        this.claspCourse = claspCourse;
    }

    public Boolean getClaspCourseName() {
        return claspCourseName;
    }

    public void setClaspCourseName(Boolean claspCourseName) {
        this.claspCourseName = claspCourseName;
    }

    public Boolean getClaspCourseMoney() {
        return claspCourseMoney;
    }

    public void setClaspCourseMoney(Boolean claspCourseMoney) {
        this.claspCourseMoney = claspCourseMoney;
    }

    public Boolean getHighEndProjects() {
        return highEndProjects;
    }

    public void setHighEndProjects(Boolean highEndProjects) {
        this.highEndProjects = highEndProjects;
    }

    public Boolean getAdviser() {
        return adviser;
    }

    public void setAdviser(Boolean adviser) {
        this.adviser = adviser;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
