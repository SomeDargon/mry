package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kaik on 2017/10/18.
 * 卡类管理
 */
@Entity
@Table(name = CardManagement.TABLE_NAME)
public class CardManagement  extends BaseEntity {

    public static final String TABLE_NAME = "card_management";

    //卡名
    @Column(name = "name")
    private String name;

    //现金价格
    @Column(name = "cash_price")
    private String cashPrice;

    //卡扣价格
    @Column(name = "buckle_price")
    private String bucklePrice;

    //配赠尊享
    @Column(name = "give_gifts_to_respect")
    private String giveGiftsToRespect;

    //现金券
    @Column(name = "cash_coupon")
    private String cashCoupon;

    //介绍返利
    @Column(name = "introduce_rebate")
    private String introduceRebate;

    //有效时间
    @Column(name = "effective_time")
    private String effectiveTime;


    //消费返利
    @Column(name = "consumption_rebate")
    private String consumptionRebate;
    //卡包含的项目
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "card", fetch = FetchType.LAZY)
    private List<CardProject> cardProject;

    //赠送项目
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "card", fetch = FetchType.LAZY)
    private List<GiftItems> giftItems;

    // 产品
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "card", fetch = FetchType.LAZY)
    private List<CardProduct>  product;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCashPrice() {
        return cashPrice;
    }

    public void setCashPrice(String cashPrice) {
        this.cashPrice = cashPrice;
    }

    public String getBucklePrice() {
        return bucklePrice;
    }

    public void setBucklePrice(String bucklePrice) {
        this.bucklePrice = bucklePrice;
    }

    public String getGiveGiftsToRespect() {
        return giveGiftsToRespect;
    }

    public void setGiveGiftsToRespect(String giveGiftsToRespect) {
        this.giveGiftsToRespect = giveGiftsToRespect;
    }

    public String getCashCoupon() {
        return cashCoupon;
    }

    public void setCashCoupon(String cashCoupon) {
        this.cashCoupon = cashCoupon;
    }

    public String getIntroduceRebate() {
        return introduceRebate;
    }

    public void setIntroduceRebate(String introduceRebate) {
        this.introduceRebate = introduceRebate;
    }

    public String getConsumptionRebate() {
        return consumptionRebate;
    }

    public void setConsumptionRebate(String consumptionRebate) {
        this.consumptionRebate = consumptionRebate;
    }

    public List<CardProject> getCardProject() {
        return cardProject;
    }

    public void setCardProject(List<CardProject> cardProject) {
        this.cardProject = cardProject;
    }

    public List<GiftItems> getGiftItems() {
        return giftItems;
    }

    public void setGiftItems(List<GiftItems> giftItems) {
        this.giftItems = giftItems;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public List<CardProduct> getProduct() {
        return product;
    }

    public void setProduct(List<CardProduct> product) {
        this.product = product;
    }
}
