package com.mry.json.system;

import com.mry.entity.store.card.CardManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2017/11/29.
 */
public class CardListJson {

    private Long id;

    //卡名
    private String name;

    //现金价格
    private String cashPrice;

    //卡扣价格
    private String bucklePrice;

    //配赠尊享
    private String giveGiftsToRespect;

    //现金券
    private String cashCoupon;

    //介绍返利
    private String introduceRebate;

    //消费返利
    private String consumptionRebate;
    //卡包含的项目
    private List<CardProjectJson> cardProject;

    //赠送项目
    private List<GiftItemsJson> giftItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<CardProjectJson> getCardProject() {
        return cardProject;
    }

    public void setCardProject(List<CardProjectJson> cardProject) {
        this.cardProject = cardProject;
    }

    public List<GiftItemsJson> getGiftItems() {
        return giftItems;
    }

    public void setGiftItems(List<GiftItemsJson> giftItems) {
        this.giftItems = giftItems;
    }

    public CardListJson(CardManagement data) {
        this.id = data.getId();
        this.name = data.getName();
        this.cashPrice = data.getCashPrice();
        this.bucklePrice = data.getBucklePrice();
        this.giveGiftsToRespect = data.getGiveGiftsToRespect();
        this.cashCoupon = data.getCashCoupon();
        this.introduceRebate = data.getIntroduceRebate();
        this.consumptionRebate = data.getConsumptionRebate();
        if(data.getCardProject() != null){
            this.cardProject = new ArrayList<>();
            data.getCardProject().forEach(a ->this.cardProject.add(new CardProjectJson(a)));
        }

        if(data.getGiftItems() != null){
            this.giftItems = new ArrayList<>();
            data.getGiftItems().forEach(a ->this.giftItems.add(new GiftItemsJson(a)));
        }

    }
}
