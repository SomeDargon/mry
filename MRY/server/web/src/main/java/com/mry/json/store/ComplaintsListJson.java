package com.mry.json.store;

import com.mry.entity.store.ComplaintsManagement;
import com.mry.util.DatetimeUtil;

/**
 * Created by kaik on 2017/11/24.
 */
public class ComplaintsListJson {


    private Long id;

    //注册店
    private String storeName;

    //注册店Id
    private Long storeId;
    //投诉人Id
    private Long customerId;

    //投诉人
    private String customerName;

    //投诉编号
    private String code;

    //被投诉人Id
    private Long btsrId;

    //被投诉人
    private String btsrName;

    //被投诉人编号
    private String complaintsCode;

    //投诉时间
    private String complaintsTime;

    //投诉原因
    private String complaintsReason;

    //处理时间
    private String processingTime;

    //处理办法
    private String treatmentMethods;

    //处理人
    private String handlePerson;

    // 处理人Id
    private Long personId;

    // 服务编码
    private String serviceCode;

    private Long serviceId;

    // 投诉状态
    private String tsStatus;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return complaintsReason;
    }

    public void setComplaintsReason(String complaintsReason) {
        this.complaintsReason = complaintsReason;
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

    public ComplaintsListJson(ComplaintsManagement data) {
        this.storeId = data.getStoreId();
        this.storeName = data.getStoreName();
        this.id = data.getId();
        this.customerId = data.getCustomerId();
        this.customerName = data.getCustomerName();
        this.code = data.getCode();
        this.btsrId = data.getBtsrId();
        this.btsrName = data.getBtsrName();
        this.complaintsCode = data.getComplaintsCode();
        this.complaintsTime = data.getComplaintsTime();
        this.complaintsReason = data.getComplaintsReason();
        this.processingTime = data.getProcessingTime();
        this.treatmentMethods = data.getTreatmentMethods();
        this.handlePerson = data.getHandlePerson();
        this.personId = data.getId();
        this.serviceCode = data.getServiceCode();
        this.serviceId = data.getServiceId();
        this.tsStatus = data.getTsStatus();
    }
}
