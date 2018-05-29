package com.mry.json.store.serviceOrder;

import com.mry.entity.store.serviceOrders.ServiceProduct;

import java.math.BigDecimal;

/**
 * Created by kaik on 2017/12/5.
 */
public class ServiceProductListJson {

    private Long id;

    //产品名字
    private String productName;

    //产品Id
    private Long productId;

    //金额
    private String money;

    //数量
    private Integer number;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ServiceProduct convert() {
        ServiceProduct s = new ServiceProduct();
        s.setProductId(this.productId);
        s.setProductName(this.productName);
        s.setMoney(new BigDecimal(this.money));
        s.setNumber(this.number);
        return s;

    }

    public ServiceProductListJson(ServiceProduct data) {
        this.id = data.getId();
        this.productName = data.getProductName();
        this.productId = data.getProductId();
        this.money = data.getMoney().toString();
        this.number = data.getNumber();
    }
}
