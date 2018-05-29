package com.mry.json.store.serviceOrder;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2017/10/27.
 * 服务单
 */
public class ServiceOrderJson {

    private Long id;

    //注册店
    private String storeName;

    //注册店Id
    private Long storeId;

    //客户id
    private Long customerId;

    //客户名字
    private String customer;

    //服务单号
    private String serviceOrderNumber;

    //账单类别(0:充值；1：退款：2：消费；3：提现)
    private String serviceType;

    //支付方式（0：储存卡；1：现金；2：储存卡+现金）
    private String paymentMethod;

    //总金额
    private BigDecimal totalAmount;

    //现金金额
    private BigDecimal cashAmount;

    //储蓄金额
    private BigDecimal savingsAmount;

    //创建时间
    private String createTime;

    //技师姓名
    private String operatorName;

    // 技师Id
    private Long operatorId;

    //指定/非指定
    private String appoint;

    //服务房间
    private String serviceRoom;

    //服务房间id
    private Long roomId;

    //售前
    private String preSale;

    //售前
    private String preId;

    //售后
    private String customerService;

    //售后
    private Long serviceId;

    //服务单状态(1:未结算；2：已结算)
    private String servicStatus;

    //服务单类别（1：现金单；2非现金单）
    private String orderType;

    //是否匿名（false:不匿名；true:匿名）
    private Boolean isAnonymous;

    //项目
    private List<ServiceProjectJson> project;

    // 产品
    private List<ServiceProductJson>  product;

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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getServiceOrderNumber() {
        return serviceOrderNumber;
    }

    public void setServiceOrderNumber(String serviceOrderNumber) {
        this.serviceOrderNumber = serviceOrderNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public BigDecimal getSavingsAmount() {
        return savingsAmount;
    }

    public void setSavingsAmount(BigDecimal savingsAmount) {
        this.savingsAmount = savingsAmount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getAppoint() {
        return appoint;
    }

    public void setAppoint(String appoint) {
        this.appoint = appoint;
    }

    public String getServiceRoom() {
        return serviceRoom;
    }

    public void setServiceRoom(String serviceRoom) {
        this.serviceRoom = serviceRoom;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getPreSale() {
        return preSale;
    }

    public void setPreSale(String preSale) {
        this.preSale = preSale;
    }

    public String getPreId() {
        return preId;
    }

    public void setPreId(String preId) {
        this.preId = preId;
    }

    public String getCustomerService() {
        return customerService;
    }

    public void setCustomerService(String customerService) {
        this.customerService = customerService;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public List<ServiceProjectJson> getProject() {
        return project;
    }

    public void setProject(List<ServiceProjectJson> project) {
        this.project = project;
    }

    public List<ServiceProductJson> getProduct() {
        return product;
    }

    public void setProduct(List<ServiceProductJson> product) {
        this.product = product;
    }

    public String getServicStatus() {
        return servicStatus;
    }

    public void setServicStatus(String servicStatus) {
        this.servicStatus = servicStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        isAnonymous = anonymous;
    }

    //    public ServiceOrderJson(ServiceOrders data) {
//        this.id = data.getId();
//        this.storeName = data.getStoreName();
//        this.storeId = data.getStoreId();
//        this.customerId = data.getCustomerId();
//        this.customer = data.getCustomer();
//        this.serviceOrderNumber = data.getServiceOrderNumber();
//        this.serviceType = data.getServiceType();
//        this.paymentMethod = data.getPaymentMethod();
//        this.totalAmount = data.getTotalAmount();
//        this.cashAmount = data.getCashAmount();
//        this.savingsAmount = data.getSavingsAmount();
//        this.createTime = DatetimeUtil.formatDate(data.getCreateTime());
//        this.operatorName = data.getOperatorName();
//        this.operatorId = data.getOperatorId();
//        this.appoint = data.getAppoint();
//        this.serviceRoom = data.getServiceRoom();
//        this.roomId = data.getRoomId();
//        this.preSale = data.getPreSale();
//        this.preId = data.getPreId();
//        this.servicStatus = data.getServicStatus();
//        this.customerService = data.getCustomerService();
//        this.serviceId = data.getServiceId();
//        if(data.getProject() != null){
//            this.project = new ArrayList<>();
//            data.getProject().forEach(a -> this.project.add(new ServiceProjectJson(a)));
//        }
//        if(data.getProduct() != null){
//            this.product = new ArrayList<>();
//            data.getProduct().forEach(a -> this.product.add(new ServiceProductJson(a)));
//        }
//
//    }
}
