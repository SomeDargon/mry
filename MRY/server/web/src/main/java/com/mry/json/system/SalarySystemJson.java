package com.mry.json.system;

import com.mry.entity.store.salary.*;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2018/1/17.
 */

public class SalarySystemJson {


    //id
    private Long id;

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    private Long storeId;

//    //底薪类型(1按月现金总量;2按月客流总量;3按月实操总量;4按月项目总数;5按固定底薪;6按员工级别底薪)
    @ApiModelProperty(value="底薪类型(1按月现金总量;2按月客流总量;3按月实操总量;4按月项目总数;5按固定底薪;6按员工级别底薪)",name="typeOfBaseSalary")
    private String typeOfBaseSalary;

    //    //类型
    @ApiModelProperty(value="类型",name="monthlyCashType")
    private String monthlyCashType;

    //底薪金额
    @ApiModelProperty(value="底薪金额",name="baseSalary")
    private BigDecimal baseSalary;

    //实操提成
    @ApiModelProperty(value="实操提成",name="practicalExercises")
    private boolean practicalExercises;

    //    //实操提成
    @ApiModelProperty(value="实操提成",name="practicalExercise")
    private List<PracticalExercise> practicalExercise;

    //业绩提成
    @ApiModelProperty(value="业绩提成",name="performanceDrawinges")
    private boolean performanceDrawinges;
    //    //业绩提成
    @ApiModelProperty(value="业绩提成",name="performanceDrawing")
    private List<PerformanceDrawing> performanceDrawing;


    //手工费
    @ApiModelProperty(value="手工费",name="manualFee")
    private boolean manualFee;

    //奖金类型(1按客流奖励;2按现金业绩奖励;3按实操奖励)
    @ApiModelProperty(value="奖金类型(1按客流奖励;2按现金业绩奖励;3按实操奖励)",name="typeOfBonus")
    private String typeOfBonus;

    //团队奖金
    @ApiModelProperty(value="团队奖金",name="teamBonuses")
    private boolean teamBonuses;

    //团队奖金
    @ApiModelProperty(value="团队奖金",name="teamBonus")
    private List<TeamBonus> teamBonus;

    //活动奖金
    @ApiModelProperty(value="活动奖金",name="activityBonuses")
    private boolean activityBonuses;

    //活动奖金
    @ApiModelProperty(value="活动奖金",name="activityBonus")
    private List<ActivityBonus> activityBonus;

    //投诉罚金
    @ApiModelProperty(value="投诉罚金",name="complaintFines")
    private boolean complaintFines;

    //投诉罚金
    @ApiModelProperty(value="投诉罚金",name="complaintFinesAmount")
    private BigDecimal complaintFinesAmount;

    //迟到早退罚金
    @ApiModelProperty(value="迟到早退罚金",name="leaveEarlyFines")
    private boolean leaveEarlyFines;

    //迟到早退罚金s
    @ApiModelProperty(value="迟到早退罚金",name="leaveEarlyFiness")
    private List<LeaveEarlyFines> leaveEarlyFiness;

    //事假罚金
    @ApiModelProperty(value="事假罚金",name="leaveAfines")
    private boolean leaveAfine;

    //事假罚金
    @ApiModelProperty(value="事假罚金",name="leaveAfine")
    private List<LeaveAfine> leaveAfines;

    //事假罚金类型(1固定罚金;2按计算规则罚金)
    @ApiModelProperty(value="事假罚金类型(1固定罚金;2按计算规则罚金))",name="typeOfLeave")
    private String typeOfLeave;

    //事假罚金
    @ApiModelProperty(value="固定罚金金额",name="leaveThePenaltyRules")
    private BigDecimal leaveThePenaltyRules;

    //旷工罚金
    @ApiModelProperty(value="旷工罚金",name="absenteeismFine")
    private boolean absenteeismFine;

    //旷工罚金
    @ApiModelProperty(value="旷工罚金",name="absenteeismFineAmount")
    private BigDecimal absenteeismFineAmount;

    //现金业绩罚金
    @ApiModelProperty(value="现金业绩罚金",name="cashPerformancePpenalty")
    private boolean cashPerformancePpenalty;

    //现金业绩罚金
    @ApiModelProperty(value="现金业绩罚金",name="cashPerformancePpenaltyes")
    private List<CashPerformancePenalty> cashPerformancePpenaltyes;

    //客流罚金
    @ApiModelProperty(value="客流罚金",name="passengerFines")
    private boolean passengerFines;

    //客流罚金
    @ApiModelProperty(value="客流罚金",name="passengerFiness")
    private List<PassengerFines> passengerFiness;

    //消耗罚金
    @ApiModelProperty(value="消耗罚金",name="consumptionPenalty")
    private boolean consumptionPenalty;

    //消耗罚金
    @ApiModelProperty(value="消耗罚金",name="consumptionPenaltyes")
    private List<ConsumptionPenalty> consumptionPenaltyes;

    //其他罚金
    @ApiModelProperty(value="其他罚金",name="otherFines")
    private boolean otherFines;

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



    public boolean isPracticalExercises() {
        return practicalExercises;
    }

    public void setPracticalExercises(boolean practicalExercises) {
        this.practicalExercises = practicalExercises;
    }

    public List<PracticalExercise> getPracticalExercise() {
        return practicalExercise;
    }

    public void setPracticalExercise(List<PracticalExercise> practicalExercise) {
        this.practicalExercise = practicalExercise;
    }

    public boolean isPerformanceDrawinges() {
        return performanceDrawinges;
    }

    public void setPerformanceDrawinges(boolean performanceDrawinges) {
        this.performanceDrawinges = performanceDrawinges;
    }

    public List<PerformanceDrawing> getPerformanceDrawing() {
        return performanceDrawing;
    }

    public void setPerformanceDrawing(List<PerformanceDrawing> performanceDrawing) {
        this.performanceDrawing = performanceDrawing;
    }

    public boolean isManualFee() {
        return manualFee;
    }

    public void setManualFee(boolean manualFee) {
        this.manualFee = manualFee;
    }


    public boolean isTeamBonuses() {
        return teamBonuses;
    }

    public void setTeamBonuses(boolean teamBonuses) {
        this.teamBonuses = teamBonuses;
    }

    public List<TeamBonus> getTeamBonus() {
        return teamBonus;
    }

    public void setTeamBonus(List<TeamBonus> teamBonus) {
        this.teamBonus = teamBonus;
    }

    public boolean isActivityBonuses() {
        return activityBonuses;
    }

    public void setActivityBonuses(boolean activityBonuses) {
        this.activityBonuses = activityBonuses;
    }

    public List<ActivityBonus> getActivityBonus() {
        return activityBonus;
    }

    public void setActivityBonus(List<ActivityBonus> activityBonus) {
        this.activityBonus = activityBonus;
    }

    public boolean isComplaintFines() {
        return complaintFines;
    }

    public void setComplaintFines(boolean complaintFines) {
        this.complaintFines = complaintFines;
    }

    public BigDecimal getComplaintFinesAmount() {
        return complaintFinesAmount;
    }

    public void setComplaintFinesAmount(BigDecimal complaintFinesAmount) {
        this.complaintFinesAmount = complaintFinesAmount;
    }

    public boolean isLeaveEarlyFines() {
        return leaveEarlyFines;
    }

    public void setLeaveEarlyFines(boolean leaveEarlyFines) {
        this.leaveEarlyFines = leaveEarlyFines;
    }

    public List<LeaveEarlyFines> getLeaveEarlyFiness() {
        return leaveEarlyFiness;
    }

    public void setLeaveEarlyFiness(List<LeaveEarlyFines> leaveEarlyFiness) {
        this.leaveEarlyFiness = leaveEarlyFiness;
    }

    public boolean isLeaveAfine() {
        return leaveAfine;
    }

    public void setLeaveAfine(boolean leaveAfine) {
        this.leaveAfine = leaveAfine;
    }

    public List<LeaveAfine> getLeaveAfines() {
        return leaveAfines;
    }

    public void setLeaveAfines(List<LeaveAfine> leaveAfines) {
        this.leaveAfines = leaveAfines;
    }

    public boolean isAbsenteeismFine() {
        return absenteeismFine;
    }

    public void setAbsenteeismFine(boolean absenteeismFine) {
        this.absenteeismFine = absenteeismFine;
    }

    public BigDecimal getAbsenteeismFineAmount() {
        return absenteeismFineAmount;
    }

    public void setAbsenteeismFineAmount(BigDecimal absenteeismFineAmount) {
        this.absenteeismFineAmount = absenteeismFineAmount;
    }

    public boolean isCashPerformancePpenalty() {
        return cashPerformancePpenalty;
    }

    public void setCashPerformancePpenalty(boolean cashPerformancePpenalty) {
        this.cashPerformancePpenalty = cashPerformancePpenalty;
    }

    public List<CashPerformancePenalty> getCashPerformancePpenaltyes() {
        return cashPerformancePpenaltyes;
    }

    public void setCashPerformancePpenaltyes(List<CashPerformancePenalty> cashPerformancePpenaltyes) {
        this.cashPerformancePpenaltyes = cashPerformancePpenaltyes;
    }

    public boolean isPassengerFines() {
        return passengerFines;
    }

    public void setPassengerFines(boolean passengerFines) {
        this.passengerFines = passengerFines;
    }

    public List<PassengerFines> getPassengerFiness() {
        return passengerFiness;
    }

    public void setPassengerFiness(List<PassengerFines> passengerFiness) {
        this.passengerFiness = passengerFiness;
    }

    public boolean isConsumptionPenalty() {
        return consumptionPenalty;
    }

    public void setConsumptionPenalty(boolean consumptionPenalty) {
        this.consumptionPenalty = consumptionPenalty;
    }

    public List<ConsumptionPenalty> getConsumptionPenaltyes() {
        return consumptionPenaltyes;
    }

    public void setConsumptionPenaltyes(List<ConsumptionPenalty> consumptionPenaltyes) {
        this.consumptionPenaltyes = consumptionPenaltyes;
    }

    public boolean isOtherFines() {
        return otherFines;
    }

    public void setOtherFines(boolean otherFines) {
        this.otherFines = otherFines;
    }

    public String getTypeOfBaseSalary() {
        return typeOfBaseSalary;
    }

    public void setTypeOfBaseSalary(String typeOfBaseSalary) {
        this.typeOfBaseSalary = typeOfBaseSalary;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getTypeOfBonus() {
        return typeOfBonus;
    }

    public void setTypeOfBonus(String typeOfBonus) {
        this.typeOfBonus = typeOfBonus;
    }

    public String getMonthlyCashType() {
        return monthlyCashType;
    }

    public void setMonthlyCashType(String monthlyCashType) {
        this.monthlyCashType = monthlyCashType;
    }

    public String getTypeOfLeave() {
        return typeOfLeave;
    }

    public void setTypeOfLeave(String typeOfLeave) {
        this.typeOfLeave = typeOfLeave;
    }

    public BigDecimal getLeaveThePenaltyRules() {
        return leaveThePenaltyRules;
    }

    public void setLeaveThePenaltyRules(BigDecimal leaveThePenaltyRules) {
        this.leaveThePenaltyRules = leaveThePenaltyRules;
    }
}
