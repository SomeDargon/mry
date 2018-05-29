package com.mry.json.store;

import java.math.BigDecimal;

/**
 * Created by kaik on 2017/10/27.
 */
public class SettlementJson {

    //服务单id
    private Long id;

    //服务单编号
    private String serviceOrderNumber;

    //服务单编号
    private String totaoMoney;

    //zf金额
    private String cashAmount;

    //卡扣金额
    private String savingsAmount;

    //支付方式（0：现金；1：服务单）
    private String payMethodh;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceOrderNumber() {
        return serviceOrderNumber;
    }

    public void setServiceOrderNumber(String serviceOrderNumber) {
        this.serviceOrderNumber = serviceOrderNumber;
    }

    public String getTotaoMoney() {
        return totaoMoney;
    }

    public void setTotaoMoney(String totaoMoney) {
        this.totaoMoney = totaoMoney;
    }

    public String getPayMethodh() {
        return payMethodh;
    }

    public void setPayMethodh(String payMethodh) {
        this.payMethodh = payMethodh;
    }

    public String getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(String cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getSavingsAmount() {
        return savingsAmount;
    }

    public void setSavingsAmount(String savingsAmount) {
        this.savingsAmount = savingsAmount;
    }
}
