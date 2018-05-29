package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kaik on 2017/12/5.
 */

@Entity
@Table(name = CardProduct.TABLE_NAME)
public class CardProduct extends BaseEntity {

    public static final String TABLE_NAME = "card_product";

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private CardManagement card;

    //产品名字
    @Column(name = "product_name")
    private String productName;

    //产品Id
    @Column(name = "product_id")
    private Long productId;

    //金额
    @Column(name = "money")
    private BigDecimal money;

    //数量
    @Column(name = "number")
    private Integer number;

    public CardManagement getCard() {
        return card;
    }

    public void setCard(CardManagement card) {
        this.card = card;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
