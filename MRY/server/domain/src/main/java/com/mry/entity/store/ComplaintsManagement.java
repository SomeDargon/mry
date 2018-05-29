package com.mry.entity.store;

import com.mry.entity.common.BaseEntity;
import com.mry.entity.store.customer.RecordsOfConsumption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/10/20.
 * 投诉管理
 */
@Entity
@Table(name = ComplaintsManagement.TABLE_NAME)
public class ComplaintsManagement extends BaseEntity {

    public static final String TABLE_NAME = "complaints_management";

    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //投诉人Id
    @Column(name = "customer_id")
    private Long customerId;

    //投诉人
    @Column(name = "customerName")
    private String customerName;

    //投诉编号
    @Column(name = "code")
    private String code;

    //被投诉人Id
    @Column(name = "btsr_id")
    private Long btsrId;

    //被投诉人
    @Column(name = "btsr_name")
    private String btsrName;

    //被投诉人编号
    @Column(name = "complaints_code")
    private String complaintsCode;

    //投诉时间
    @Column(name = "ComplaintsTime")
    private String complaintsTime;

    //投诉原因
    @Column(name = "ComplaintsReason")
    private String ComplaintsReason;

    //处理时间
    @Column(name = "processing_time")
    private String processingTime;

    //处理办法
    @Column(name = "treatment_methods")
    private String treatmentMethods;

    //处理人
    @Column(name = "handle_person")
    private String handlePerson;

    // 处理人Id
    @Column(name = "personId")
    private Long personId;

    // 服务编码
    @Column(name = "service_code")
    private String serviceCode;

    // 投诉状态
    @Column(name = "ts_status")
    private String tsStatus;


    //服务单Id
    @Column(name = "service_id")
    private Long serviceId;

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getBtsrId() {
        return btsrId;
    }

    public void setBtsrId(Long btsrId) {
        this.btsrId = btsrId;
    }

    public String getBtsrName() {
        return btsrName;
    }

    public void setBtsrName(String btsrName) {
        this.btsrName = btsrName;
    }

    public String getComplaintsCode() {
        return complaintsCode;
    }

    public void setComplaintsCode(String complaintsCode) {
        this.complaintsCode = complaintsCode;
    }

    public String getComplaintsTime() {
        return complaintsTime;
    }

    public void setComplaintsTime(String complaintsTime) {
        this.complaintsTime = complaintsTime;
    }

    public String getComplaintsReason() {
        return ComplaintsReason;
    }

    public void setComplaintsReason(String complaintsReason) {
        ComplaintsReason = complaintsReason;
    }

    public String getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(String processingTime) {
        this.processingTime = processingTime;
    }

    public String getTreatmentMethods() {
        return treatmentMethods;
    }

    public void setTreatmentMethods(String treatmentMethods) {
        this.treatmentMethods = treatmentMethods;
    }

    public String getHandlePerson() {
        return handlePerson;
    }

    public void setHandlePerson(String handlePerson) {
        this.handlePerson = handlePerson;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getTsStatus() {
        return tsStatus;
    }

    public void setTsStatus(String tsStatus) {
        this.tsStatus = tsStatus;
    }
}
