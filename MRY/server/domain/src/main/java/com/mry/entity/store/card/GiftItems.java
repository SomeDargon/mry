package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kaik on 2017/10/19.
 * 赠送项目
 */
@Entity
@Table(name = GiftItems.TABLE_NAME)
public class GiftItems  extends BaseEntity {

    public static final String TABLE_NAME = "gift_items";



    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private CardManagement card;

    //项目id
    @Column(name = "project_id")
    private Long projectId;

    //项目名称
    @Column(name = "project_name")
    private String projectName;

    //项目价格
    @Column(name = "project_price")
    private BigDecimal projectPrice;

    //次数
    @Column(name = "frequency")
    private Integer frequency;

    //间隔
    @Column(name = "intervalTime")
    private Integer intervalTime;

    public CardManagement getCard() {
        return card;
    }

    public void setCard(CardManagement card) {
        this.card = card;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BigDecimal getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(BigDecimal projectPrice) {
        this.projectPrice = projectPrice;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(Integer intervalTime) {
        this.intervalTime = intervalTime;
    }
}
