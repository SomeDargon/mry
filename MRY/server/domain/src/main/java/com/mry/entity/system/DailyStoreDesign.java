package com.mry.entity.system;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2018/1/16.
 * 单店日报设计
 */
@ApiModel(value="单店日报设计",description="单店日报设计")
@Entity
@Table(name = DailyStoreDesign.TABLE_NAME)
public class DailyStoreDesign extends BaseEntity {

    public static final String TABLE_NAME = "daily_store_design";

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    @Column(name = "store_id")
    private Long storeId;

    //序号
    @ApiModelProperty(value="序号",name="serialNumber")
    @Column(name = "serial_number")
    private Boolean serialNumber=true;

    //顾客姓名
    @ApiModelProperty(value="顾客姓名",name="storeId")
    @Column(name = "customer_name")
    private Boolean customerName=true;

    //服务项目或产品
    @ApiModelProperty(value="服务项目或产品",name="serviceItems")
    @Column(name = "service_items")
    private Boolean serviceItems=true;

    //现金
    @ApiModelProperty(value="现金",name="cash")
    @Column(name = "cash")
    private Boolean cash=true;

    //实操
    @ApiModelProperty(value="实操",name="practicalOperation")
    @Column(name = "practical_operation")
    private Boolean practicalOperation=true;

    //卡扣
    @ApiModelProperty(value="卡扣",name="buckle")
    @Column(name = "buckle")
    private Boolean buckle=true;

    //顾问
    @ApiModelProperty(value="顾问",name="adviser")
    @Column(name = "adviser")
    private Boolean adviser=true;

    //
    @ApiModelProperty(value="服务部门",name="serviceDepartment")
    @Column(name = "service_department")
    private Boolean serviceDepartment=true;

    //
    @ApiModelProperty(value="服务人员",name="servicePersonal")
    @Column(name = "service_personal")
    private Boolean servicePersonal=true;


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

    public Boolean getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Boolean serialNumber) {
        this.serialNumber = serialNumber;
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

    public Boolean getCash() {
        return cash;
    }

    public void setCash(Boolean cash) {
        this.cash = cash;
    }

    public Boolean getPracticalOperation() {
        return practicalOperation;
    }

    public void setPracticalOperation(Boolean practicalOperation) {
        this.practicalOperation = practicalOperation;
    }

    public Boolean getBuckle() {
        return buckle;
    }

    public void setBuckle(Boolean buckle) {
        this.buckle = buckle;
    }

    public Boolean getAdviser() {
        return adviser;
    }

    public void setAdviser(Boolean adviser) {
        this.adviser = adviser;
    }

    public Boolean getServiceDepartment() {
        return serviceDepartment;
    }

    public void setServiceDepartment(Boolean serviceDepartment) {
        this.serviceDepartment = serviceDepartment;
    }

    public Boolean getServicePersonal() {
        return servicePersonal;
    }

    public void setServicePersonal(Boolean servicePersonal) {
        this.servicePersonal = servicePersonal;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
