package com.mry.entity.store.serviceOrders;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kaik on 2017/10/20.
 * 服务单项目
 */
@Entity
@Table(name = ServiceProject.TABLE_NAME)
public class ServiceProject  extends BaseEntity {

    public static final String TABLE_NAME = "service_project";


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "sercice_id")
    private ServiceOrders order;

    //卡id
    @Column(name = "card_id")
    private Long cardId;

    //卡名字
    @Column(name = "card_name")
    private String cardName;

    //项目名字
    @Column(name = "project_name")
    private String projectName;

    //项目Id
    @Column(name = "project_id")
    private Long projectId;

    //金额
    @Column(name = "money")
    private BigDecimal money;

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

    public ServiceOrders getOrder() {
        return order;
    }

    public void setOrder(ServiceOrders order) {
        this.order = order;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
