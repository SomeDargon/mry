package com.mry.entity.system;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2018/1/16.
 *  美发技师月报表
 */
@ApiModel(value="美发技师月报表",description="美发技师月报表")
@Entity
@Table(name = HairTechnicianMonthlyReport.TABLE_NAME)
public class HairTechnicianMonthlyReport extends BaseEntity {

    public static final String TABLE_NAME = "hair_technician_monthly_report";

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

    //总业绩
    @ApiModelProperty(value="总业绩",name="totalPerformance")
    @Column(name = "total_performance")
    private Boolean totalPerformance=true;

    //总实操
    @ApiModelProperty(value="总实操",name="theTotalOperation")
    @Column(name = "the_total_operation")
    private Boolean theTotalOperation=true;

    //现金业绩（不含产品）
    @ApiModelProperty(value="现金业绩（不含产品",name="cashPerformance")
    @Column(name = "cash_performance")
    private Boolean cashPerformance=true;

    //实操
    @ApiModelProperty(value="实操",name="practicalOperation")
    @Column(name = "practical_operation")
    private Boolean practicalOperation=true;

    //实操 指定
    @ApiModelProperty(value="实操指定",name="practicalOperationAppoint")
    @Column(name = "practical_operation_appoint")
    private Boolean practicalOperationAppoint=true;

    //实操非指定
    @ApiModelProperty(value="实操非指定",name="practicalOperationNonSpecifiedt")
    @Column(name = "practical_operation_non_specified")
    private Boolean practicalOperationNonSpecifiedt=true;

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

    public Boolean getTotalPerformance() {
        return totalPerformance;
    }

    public void setTotalPerformance(Boolean totalPerformance) {
        this.totalPerformance = totalPerformance;
    }

    public Boolean getTheTotalOperation() {
        return theTotalOperation;
    }

    public void setTheTotalOperation(Boolean theTotalOperation) {
        this.theTotalOperation = theTotalOperation;
    }

    public Boolean getCashPerformance() {
        return cashPerformance;
    }

    public void setCashPerformance(Boolean cashPerformance) {
        this.cashPerformance = cashPerformance;
    }

    public Boolean getPracticalOperation() {
        return practicalOperation;
    }

    public void setPracticalOperation(Boolean practicalOperation) {
        this.practicalOperation = practicalOperation;
    }

    public Boolean getPracticalOperationAppoint() {
        return practicalOperationAppoint;
    }

    public void setPracticalOperationAppoint(Boolean practicalOperationAppoint) {
        this.practicalOperationAppoint = practicalOperationAppoint;
    }

    public Boolean getPracticalOperationNonSpecifiedt() {
        return practicalOperationNonSpecifiedt;
    }

    public void setPracticalOperationNonSpecifiedt(Boolean practicalOperationNonSpecifiedt) {
        this.practicalOperationNonSpecifiedt = practicalOperationNonSpecifiedt;
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

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
