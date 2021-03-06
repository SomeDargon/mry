package com.mry.json.store.serviceOrder;

import com.mry.entity.store.serviceOrders.ServiceProduct;
import com.mry.entity.store.serviceOrders.ServiceProject;

import java.math.BigDecimal;

/**
 * Created by kaik on 2017/10/27.
 */
public class ServiceProjectJson {

    private Long id;


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


    public ServiceProject convert() {
        ServiceProject s = new ServiceProject();
        s.setProjectName(this.projectName);
        s.setProjectId(this.projectId);
        if(this.money!=null){
            s.setMoney(new BigDecimal(this.money));
        }else {
            s.setMoney(new BigDecimal(0.0));
        }

        return s;
    }

    public ServiceProjectJson(ServiceProject data) {
        this.id = data.getId();
        this.projectName = data.getProjectName();
        this.projectId = data.getProjectId();
        this.money = data.getMoney().toString();

    }
    public ServiceProjectJson(){}

}
