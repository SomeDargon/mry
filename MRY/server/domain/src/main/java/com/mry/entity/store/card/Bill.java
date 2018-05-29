package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kaik on 2017/10/25.
 * 账单
 */
@Entity
@Table(name = Bill.TABLE_NAME)
public class Bill  extends BaseEntity {

    public static final String TABLE_NAME = "bill";

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

    //服务单id
    @Column(name = "service_id")
    private Long serviceId;

    //服务单号
    @Column(name = "service_order_number")
    private String serviceOrderNumber;

    //账单类别(0:充值；1：退款：2：消费；3：提现)
    @Column(name = "bill_type")
    private String billType;

    //支付方式（0：现金；1：储蓄卡；2：银联卡；3：支付宝；4：微信）
    @Column(name = "payment_method")
    private String paymentMethod;

    //支付金额
    @Column(name = "zfmoney")
    private BigDecimal zfmoney;
    //总金额
    @Column(name = "money")
    private BigDecimal money;
    //卡扣金额
    @Column(name = "kkmoney")
    private BigDecimal kkmoney;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

    //时间
    @Column(name = "bill_time")
    private Date billTime;

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

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }


    public String getServiceOrderNumber() {
        return serviceOrderNumber;
    }

    public void setServiceOrderNumber(String serviceOrderNumber) {
        this.serviceOrderNumber = serviceOrderNumber;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getZfmoney() {
        return zfmoney;
    }

    public void setZfmoney(BigDecimal zfmoney) {
        this.zfmoney = zfmoney;
    }

    public BigDecimal getKkmoney() {
        return kkmoney;
    }

    public void setKkmoney(BigDecimal kkmoney) {
        this.kkmoney = kkmoney;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    ;


}
