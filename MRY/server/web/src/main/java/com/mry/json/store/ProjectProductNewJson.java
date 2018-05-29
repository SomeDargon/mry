package com.mry.json.store;

import com.mry.entity.store.project.ProjectProduct;

import java.math.BigDecimal;

/**
 * Created by kaik on 2017/12/27.
 */
public class ProjectProductNewJson {

    private Long id;
    //产品id
    private Long productId;

    //名字
    private String productName;

    //金额
    private String money;

    //编号
    private String code;

    //介绍
    private String introduce;



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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProjectProduct convert() {
        ProjectProduct s = new ProjectProduct();
        s.setCode(this.code);
        s.setProductName(this.productName);
        s.setIntroduce(this.introduce);
        s.setProductId(this.productId);
        if(this.money != null && this.money !="") {
            s.setMoney(new BigDecimal(this.money));
        }
        return s;
    }


}
