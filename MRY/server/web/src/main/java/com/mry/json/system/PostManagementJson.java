package com.mry.json.system;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * Created by kaik on 2017/12/25.
 */
public class PostManagementJson {


    private Long id;

    //注册店
    private String storeName;

    //注册店Id
    private Long storeId;

    //职位名称
    private String postName;

    //岗位职责
    private String postDuties;

    //工作流程
    private String workflow;

    //行为绩效与评分
    private String achievements;

    //技术考核
    private String technicalExamination;

    //员工类型
    private String employeeType;

    //员工等级
    private String employeeRank;

    //考勤
    private String checkWorkAttendance;

    //员工数据排名（单月／多月现金
    private String multiMonthCash;

    //员工数据排名（单月／多月现金
    private String dataRankings;

    //入股金额
    private String shareAmount;

    //分红管理
    private String dividendManagement;

    //股权性质（干股/实股）
    private String natureOfEquity;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostDuties() {
        return postDuties;
    }

    public void setPostDuties(String postDuties) {
        this.postDuties = postDuties;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getTechnicalExamination() {
        return technicalExamination;
    }

    public void setTechnicalExamination(String technicalExamination) {
        this.technicalExamination = technicalExamination;
    }

    public String getCheckWorkAttendance() {
        return checkWorkAttendance;
    }

    public void setCheckWorkAttendance(String checkWorkAttendance) {
        this.checkWorkAttendance = checkWorkAttendance;
    }

    public String getMultiMonthCash() {
        return multiMonthCash;
    }

    public void setMultiMonthCash(String multiMonthCash) {
        this.multiMonthCash = multiMonthCash;
    }

    public String getDataRankings() {
        return dataRankings;
    }

    public void setDataRankings(String dataRankings) {
        this.dataRankings = dataRankings;
    }

    public String getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(String shareAmount) {
        this.shareAmount = shareAmount;
    }

    public String getDividendManagement() {
        return dividendManagement;
    }

    public void setDividendManagement(String dividendManagement) {
        this.dividendManagement = dividendManagement;
    }

    public String getNatureOfEquity() {
        return natureOfEquity;
    }

    public void setNatureOfEquity(String natureOfEquity) {
        this.natureOfEquity = natureOfEquity;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeRank() {
        return employeeRank;
    }

    public void setEmployeeRank(String employeeRank) {
        this.employeeRank = employeeRank;
    }
}
