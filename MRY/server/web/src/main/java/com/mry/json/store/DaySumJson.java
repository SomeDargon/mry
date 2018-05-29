package com.mry.json.store;

import java.math.BigDecimal;

/**
 * Created by kaik on 2017/12/1.
 */
public class DaySumJson {
    //客流
    private Long passengerNumber;

    //现金
    private BigDecimal cash;

    //实操
    private String practicalOperation;

    //实耗
    private String realConsumption;


    public Long getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(Long passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public String getPracticalOperation() {
        return practicalOperation;
    }

    public void setPracticalOperation(String practicalOperation) {
        this.practicalOperation = practicalOperation;
    }

    public String getRealConsumption() {
        return realConsumption;
    }

    public void setRealConsumption(String realConsumption) {
        this.realConsumption = realConsumption;
    }

    public DaySumJson(Long passengerNumber, BigDecimal cash) {
        this.passengerNumber = passengerNumber;
        this.cash = cash;
    }
}
