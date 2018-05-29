package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2017/11/29.
 */
@Entity
@Table(name = OwningCard.TABLE_NAME)
public class OwningCard extends BaseEntity {

    public static final String TABLE_NAME = "owning_card";

    //卡名
    @Column(name = "card_Name")
    private String cardName;
    //类型
    @Column(name = "card_type")
    private Integer cardType;

    //类型名称
    @Column(name = "card_type_name")
    private String cardTypeName;
    //卡名
    @Column(name = "card_id")
    private Long cardId;

    //
    @Column(name = "customer_id")
    private Long customerId;

    //开卡时间
    @Column(name = "open_time")
    private Date openTime;

    //结束时间
    @Column(name = "end_time")
    private Date endTime;

    //卡包含的项目
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "card", fetch = FetchType.LAZY)
    private List<MyProject>project;

    //卡包含的项目
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "card", fetch = FetchType.LAZY)
    private List<MyProduct>product;

    //卡状态(1:启用；2：禁用；3过期)
    @Column(name = "card_status")
    private String cardStatus;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

    //备注
    @Column(name = "bz")
    private String bz;

    public List<MyProject> getProject() {
        return project;
    }

    public void setProject(List<MyProject> project) {
        this.project = project;
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

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public List<MyProduct> getProduct() {
        return product;
    }

    public void setProduct(List<MyProduct> product) {
        this.product = product;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }
}
