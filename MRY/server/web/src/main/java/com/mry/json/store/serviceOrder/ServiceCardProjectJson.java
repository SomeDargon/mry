package com.mry.json.store.serviceOrder;

import com.mry.entity.store.serviceOrders.ServiceProject;

/**
 * Created by kaik on 2017/12/7.
 */
public class ServiceCardProjectJson {

    //卡id
    private Long id;


    //卡id
    private Long cardId;

    //卡名字
    private String cardName;

    //项目名字
    private String projectName;

    //项目Id
    private Long projectId;

    //金额
    private String money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public ServiceCardProjectJson(ServiceProject data) {
        this.id = data.getId();
        this.cardId = data.getCardId();
        this.cardName = data.getCardName();
        this.projectName = data.getProjectName();
        this.projectId = data.getProjectId();
        this.money = data.getMoney()==null?"":data.getMoney()+"";
    }
}
