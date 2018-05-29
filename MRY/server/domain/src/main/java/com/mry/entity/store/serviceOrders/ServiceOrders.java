package com.mry.entity.store.serviceOrders;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2017/10/20.
 * 服务单
 */
@Entity
@Table(name = ServiceOrders.TABLE_NAME)
public class ServiceOrders extends BaseEntity {

    public static final String TABLE_NAME = "service_orders";

    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //客户id
    @Column(name = "customer_id")
    private Long customerId;

    //客户名字
    @Column(name = "customer")
    private String customer;

    //电话
    @Column(name = "phone_number")
    private String phoneNumber;

    //会员等级
    @Column(name = "level")
    private String level;

    //服务单类别（0：现金单；1非现金）
    @Column(name = "order_type")
    private String orderType;

    //是否匿名
    @Column(name = "is_anonymous")
    private Boolean isAnonymous;

    //服务单号
    @Column(name = "service_order_number")
    private String serviceOrderNumber;

    //账单类别(0:充值；1：退款：2：消费；3：提现)
    @Column(name = "service_type")
    private String serviceType;

    //支付方式（0：储存卡；1：现金；2：储存卡+现金）
    @Column(name = "payment_method")
    private String paymentMethod;

    //总金额
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    //支付金额
    @Column(name = "cash_amount")
    private BigDecimal cashAmount;

    //卡扣金额
    @Column(name = "savings_amount")
    private BigDecimal savingsAmount;

    //创建时间
    @Column(name = "create_time")
    private Date createTime;

    //技师姓名
    @Column(name = "operator_name")
    private String operatorName;

    // 技师Id
    @Column(name = "operator_id")
    private Long operatorId;

    //指定/非指定
    @Column(name = "appoint")
    private String appoint;

    //服务房间
    @Column(name = "service_room")
    private String serviceRoom;

    //服务房间id
    @Column(name = "room_id")
    private Long roomId;


    //售前
    @Column(name = "pre_sale")
    private String preSale;

    //售前
    @Column(name = "pre_id")
    private String preId;

    //售后
    @Column(name = "customer_service")
    private String customerService;

    //服务单状态(1:未结算；2：已结算)
    @Column(name = "servic_status")
    private String servicStatus;

    //售后
    @Column(name = "service_id")
    private Long serviceId;

    //项目
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    private List<ServiceProject> project;

    // 产品
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    private List<ServiceProduct>  product;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;



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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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

    public List<ServiceProject> getProject() {
        return project;
    }

    public void setProject(List<ServiceProject> project) {
        this.project = project;
    }

    public List<ServiceProduct> getProduct() {
        return product;
    }

    public void setProduct(List<ServiceProduct> product) {
        this.product = product;
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

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
