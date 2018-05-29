package com.mry.json.store;

import com.mry.entity.store.customer.MyProblemCheck;
import com.mry.util.DatetimeUtil;

/**
 * Created by kaik on 2017/12/14.
 */
public class MyProblemCheckJson {

    //客户id
    private Long id;

    //客户id
    private Long customerId;

    //客户名字
    private String customer;

    //问题idas
    private Long[] proids;

    //问题描述
    private String description;

    //测试时间
    private String checkTime;

    //状态
    private String proStatus;

    //方案（1：基础；2：推荐；3最有）
    private String programme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long[] getProids() {
        return proids;
    }

    public void setProids(Long[] proids) {
        this.proids = proids;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public MyProblemCheckJson(MyProblemCheck data) {
        this.id = data.getId();
        this.customerId = data.getCustomerId();
        this.customer = data.getCustomer();
        this.proids = data.getProids();
        this.description = data.getDescription();
        this.checkTime = DatetimeUtil.formatDate(data.getCheckTime());
        this.proStatus = data.getProStatus();
        this.programme = data.getProgramme();
    }
}
