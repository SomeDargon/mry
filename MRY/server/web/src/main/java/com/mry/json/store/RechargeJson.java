package com.mry.json.store;

import java.math.BigDecimal;

/**
 * Created by kaik on 2017/12/11.
 */
public class RechargeJson {

    private Long customerId;

    private BigDecimal money;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
