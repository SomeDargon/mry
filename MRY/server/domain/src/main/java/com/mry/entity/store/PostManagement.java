package com.mry.entity.store;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by kaik on 2017/12/25.
 */
@Entity
@Table(name = PostManagement.TABLE_NAME)
public class PostManagement extends BaseEntity {

    public static final String TABLE_NAME = "post_management";

    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //职位名称
    @Column(name = "post_name")
    private String postName;

    //岗位职责
    @Column(name = "post_duties")
    private String postDuties;

    //工作流程
    @Column(name = "workflow")
    private String workflow;

    //行为绩效与评分
    @Column(name = "achievements")
    private String achievements;

    //技术考核
    @Column(name = "technical_examination")
    private String technicalExamination;

    //员工数据排名（单月／多月现金
    @Column(name = "multi_month_cash")
    private BigDecimal multiMonthCash;

    //员工数据排名（单月／多月现金
    @Column(name = "data_rankings")
    private String dataRankings;

    //入股金额
    @Column(name = "share_amount")
    private BigDecimal shareAmount;

    //分红管理
    @Column(name = "dividend_management")
    private String dividendManagement;

    //股权性质（干股/实股）
    @Column(name = "nature_of_equity")
    private String natureOfEquity;


    //员工类型
    @Column(name = "employee_type")
    private String employeeType;

    //员工等级
    @Column(name = "employee_rank")
    private String employeeRank;


    //考勤
    @Column(name = "check_work_attendance")
    private String checkWorkAttendance;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

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

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public BigDecimal getMultiMonthCash() {
        return multiMonthCash;
    }

    public void setMultiMonthCash(BigDecimal multiMonthCash) {
        this.multiMonthCash = multiMonthCash;
    }

    public String getDataRankings() {
        return dataRankings;
    }

    public void setDataRankings(String dataRankings) {
        this.dataRankings = dataRankings;
    }

    public BigDecimal getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(BigDecimal shareAmount) {
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
