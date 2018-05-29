package com.mry.json.store;

/**
 * Created by kaik on 2017/12/15.
 */
public class MyProblemJson {
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
    //治疗结果
    private String completionPlan;
    //时间
    private String completionTime;



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

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCompletionPlan() {
        return completionPlan;
    }

    public void setCompletionPlan(String completionPlan) {
        this.completionPlan = completionPlan;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }
}
