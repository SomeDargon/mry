package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kaik on 2017/10/19.
 */
@Entity
@Table(name = CardProject.TABLE_NAME)
public class CardProject  extends BaseEntity {

    public static final String TABLE_NAME = "card_project";


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

//    //剩余次数
//    @Column(name = "remaining")
//    private Integer remaining;


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public CardManagement getCard() {
        return card;
    }

    public void setCard(CardManagement card) {
        this.card = card;
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
