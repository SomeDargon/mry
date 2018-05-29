package com.mry.json.store;

import com.mry.entity.store.customer.OwningCard;
import com.mry.util.DatetimeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2017/12/4.
 */
public class OwningCardListJson {

    //卡名
    private Long id;

    //卡名
    private String cardName;

    //卡名
    private Long cardId;

    //
    private Long customerId;

    private String cardTypeName;

    //开卡时间
    private String openTime;

    //结束时间
    private String endTime;

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    //卡包含的项目
    private List<MyProjectJson> project;

    //备注
    private String bz;

    //卡状态
    private String cardStatus;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<MyProjectJson> getProject() {
        return project;
    }

    public void setProject(List<MyProjectJson> project) {
        this.project = project;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public OwningCardListJson(OwningCard data) {
        this.id = data.getId();
        this.cardName = data.getCardName();
        this.cardId = data.getId();
        this.customerId = data.getCustomerId();
        this.openTime = DatetimeUtil.formatDate(data.getOpenTime());
        this.endTime =  DatetimeUtil.formatDate(data.getEndTime());
        this.cardTypeName = data.getCardTypeName();
        this.bz = data.getBz();
      //  this.cardStatus = data.getCardStatus();
        if(data.getProject() != null){
            this.project = new ArrayList<>();
            data.getProject().forEach(a -> this.project.add(new MyProjectJson(a)));
        }
    }


}
