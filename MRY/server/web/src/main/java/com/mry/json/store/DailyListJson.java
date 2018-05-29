package com.mry.json.store;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kaik on 2017/11/30.
 * 日报表
 */
public class DailyListJson {

    //注册店
    private String storeName;

    //真实姓名
    private String customerName;

    //服务单id
    private Long serviceId;

    //服务单号
    private String serviceOrderNumber;


    //账单类别(0:充值；1：退款：2：消费；3：提现)
    private String billType;

    //支付方式（0：现金；1：储蓄卡；2：银联卡；3：支付宝；4：微信）
    private String paymentMethod;

    //金额
    private BigDecimal money;

    //时间
    private Date billTime;
    //技师
    private String operatorName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceOrderNumber() {
        return serviceOrderNumber;
    }

    public void setServiceOrderNumber(String serviceOrderNumber) {
        this.serviceOrderNumber = serviceOrderNumber;
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

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public DailyListJson(String storeName, String customerName, Long serviceId, String serviceOrderNumber, String billType, String paymentMethod, BigDecimal money, Date billTime) {
        this.storeName = storeName;
        this.customerName = customerName;
        this.serviceId = serviceId;
        this.serviceOrderNumber = serviceOrderNumber;
        this.billType = billType;
        this.paymentMethod = paymentMethod;
        this.money = money;
        this.billTime = billTime;
     //   this.operatorName = operatorName;
    }
}
