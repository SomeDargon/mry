package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by kaik on 2018/1/10.
 * 产品卡管理
 */
@Entity
@Table(name = ProductCardManagement.TABLE_NAME)
public class ProductCardManagement extends BaseEntity {

    public static final String TABLE_NAME = "product_card_management";

    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //产品卡名称
    @Column(name = "product_card_Name")
    private String productCardName;

    //产品卡金额
    @Column(name = "product_card_money")
    private BigDecimal productCardMoney;

//    //购买金额
//    @Column(name = "money")
//    private BigDecimal money;

    //现金金额
    @Column(name = "cash_price")
    private BigDecimal cashPrice;

    //卡扣金额
    @Column(name = "bckle_price")
    private BigDecimal bucklePrice;

    //产品卡有效期(月)
    @Column(name = "product_card_validity")
    private Integer productCardValidity;


    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;


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

    public String getProductCardName() {
        return productCardName;
    }

    public void setProductCardName(String productCardName) {
        this.productCardName = productCardName;
    }

    public BigDecimal getProductCardMoney() {
        return productCardMoney;
    }

    public void setProductCardMoney(BigDecimal productCardMoney) {
        this.productCardMoney = productCardMoney;
    }

    public Integer getProductCardValidity() {
        return productCardValidity;
    }

    public void setProductCardValidity(Integer productCardValidity) {
        this.productCardValidity = productCardValidity;
    }

    public BigDecimal getCashPrice() {
        return cashPrice;
    }

    public void setCashPrice(BigDecimal cashPrice) {
        this.cashPrice = cashPrice;
    }

    public BigDecimal getBucklePrice() {
        return bucklePrice;
    }

    public void setBucklePrice(BigDecimal bucklePrice) {
        this.bucklePrice = bucklePrice;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
