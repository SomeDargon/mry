package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by kaik on 2017/12/14.
 */
@Entity
@Table(name = MyProblemCheck.TABLE_NAME)
public class MyProblemCheck extends BaseEntity {

    public static final String TABLE_NAME = "my_problem_check";

    //客户id
    @Column(name = "customer_id")
    private Long customerId;

    //客户名字
    @Column(name = "customer")
    private String customer;

    //问题idas
    @Column(name = "proids")
    private Long[] proids;

    //问题描述
    @Column(name = "description")
    private String description;

    //测试时间
    @Column(name = "check_time")
    private Date checkTime;

    //状态
    @Column(name = "pro_status")
    private String proStatus;

    //方案（1：基础；2：推荐；3最有）
    @Column(name = "programme")
    private String programme;

    //方案开始时间
    @Column(name = "begin_time")
    private Date beginTime;

    //方案描述
    @Column(name = "des_programme")
    private String desProgramme;

    //治疗结果
    @Column(name = "completion_plan")
    private String completionPlan;
    //时间
    @Column(name = "completion_time")
    private Date completionTime;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

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

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
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

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getDesProgramme() {
        return desProgramme;
    }

    public void setDesProgramme(String desProgramme) {
        this.desProgramme = desProgramme;
    }

    public String getCompletionPlan() {
        return completionPlan;
    }

    public void setCompletionPlan(String completionPlan) {
        this.completionPlan = completionPlan;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }
}
