package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;
import com.mry.entity.store.card.CardManagement;
import com.mry.entity.store.card.CardProject;

import javax.persistence.*;

/**
 * Created by kaik on 2017/10/20.
 * 我的卡项目
 */
@Entity
@Table(name = MyProject.TABLE_NAME)
public class MyProject extends BaseEntity {

    public static final String TABLE_NAME = "my_project";

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "owning_card_id")
    private OwningCard card;

    //客户id
    @Column(name = "customer_id")
    private Long customerId;

    //客户名字
    @Column(name = "customer")
    private String customer;

    //卡项目id
    @Column(name = "project_id")
    private Long projectId;

    //项目名字
    @Column(name = "project")
    private String project;

    //卡id
    @Column(name = "card_id")
    private Long cardId;

    //剩余次数
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
