package com.mry.entity.system;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2018/1/16.
 */
@ApiModel(value="新增单店月报设计",description="新增单店月报设计")
@Entity
@Table(name = ShopMonthlyReport.TABLE_NAME)
public class ShopMonthlyReport extends BaseEntity {

    public static final String TABLE_NAME = "shop_monthly_report";

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

    //现金业绩
    @ApiModelProperty(value="现金业绩",name="cashPerformance")
    @Column(name = "cash_performance")
    private Boolean cashPerformance=true;

    //客流
    @ApiModelProperty(value="客流",name="passengerFlow")
    @Column(name = "passenger_flow")
    private Boolean passengerFlow=true;

    //实操

    @ApiModelProperty(value="实操",name="practicalOperation")
    @Column(name = "practical_operation")
    private Boolean practicalOperation=true;

    //现金产品
    @ApiModelProperty(value="现金产品",name="cashProducts")
    @Column(name = "cash_products")
    private Boolean cashProducts=true;

    //卡扣产品
    @ApiModelProperty(value="buckleProduct",name="buckleProduct")
    @Column(name = "buckle_product")
    private Boolean buckleProduct=true;

    //实耗
    @ApiModelProperty(value="实耗",name="realConsumption")
    @Column(name = "real_consumption")
    private Boolean realConsumption=true;

    //高端项目现金
    @ApiModelProperty(value="高端项目现金",name="highEndProjectCash")
    @Column(name = "high_end_project_cash")
    private Boolean highEndProjectCash=true;

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

    public Boolean getCashPerformance() {
        return cashPerformance;
    }

    public void setCashPerformance(Boolean cashPerformance) {
        this.cashPerformance = cashPerformance;
    }

    public Boolean getPassengerFlow() {
        return passengerFlow;
    }

    public void setPassengerFlow(Boolean passengerFlow) {
        this.passengerFlow = passengerFlow;
    }

    public Boolean getPracticalOperation() {
        return practicalOperation;
    }

    public void setPracticalOperation(Boolean practicalOperation) {
        this.practicalOperation = practicalOperation;
    }

    public Boolean getCashProducts() {
        return cashProducts;
    }

    public void setCashProducts(Boolean cashProducts) {
        this.cashProducts = cashProducts;
    }

    public Boolean getBuckleProduct() {
        return buckleProduct;
    }

    public void setBuckleProduct(Boolean buckleProduct) {
        this.buckleProduct = buckleProduct;
    }

    public Boolean getRealConsumption() {
        return realConsumption;
    }

    public void setRealConsumption(Boolean realConsumption) {
        this.realConsumption = realConsumption;
    }

    public Boolean getHighEndProjectCash() {
        return highEndProjectCash;
    }

    public void setHighEndProjectCash(Boolean highEndProjectCash) {
        this.highEndProjectCash = highEndProjectCash;
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
}
