package com.mry.json;

/**
 * Created by kaik on 2017/11/16.
 */
public class PayResult {
    private String orderNo;
    private String result;

    public PayResult() {
    }

    public PayResult(String orderNo, String result) {
        this.orderNo = orderNo;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
