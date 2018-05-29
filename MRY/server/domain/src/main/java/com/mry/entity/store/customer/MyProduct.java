package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;

/**
 * Created by kaik on 2017/12/5.
 * 我的卡产品
 */
@Entity
@Table(name = MyProduct.TABLE_NAME)
public class MyProduct extends BaseEntity {

    public static final String TABLE_NAME = "my_product";

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "owning_card_id")
    private OwningCard card;

    //客户id
    @Column(name = "customer_id")
    private Long customerId;



    //客户名字
    @Column(name = "customer")
    private String customer;

    //产品id
    @Column(name = "product_id")
    private Long productId;

    //产品名字
    @Column(name = "product")
    private String product;

    //卡id
    @Column(name = "card_id")
    private Long cardId;

    //产品数量
    @Column(name = "remaining")
    private Integer remaining;

    public OwningCard getCard() {
        return card;
    }

    public void setCard(OwningCard card) {
        this.card = card;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }


}
