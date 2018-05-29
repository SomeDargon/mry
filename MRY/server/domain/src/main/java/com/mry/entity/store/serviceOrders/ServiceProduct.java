package com.mry.entity.store.serviceOrders;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kaik on 2017/10/20.
 * 服务单产品
 */
@Entity
@Table(name = ServiceProduct.TABLE_NAME)
public class ServiceProduct  extends BaseEntity {

    public static final String TABLE_NAME = "service_product";


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "sercice_id")
    private ServiceOrders order;


    //卡id
    @Column(name = "card_id")
    private Long cardId;

    //卡名字
    @Column(name = "card_name")
    private String cardName;

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

    public ServiceOrders getOrder() {
        return order;
    }

    public void setOrder(ServiceOrders order) {
        this.order = order;
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

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
