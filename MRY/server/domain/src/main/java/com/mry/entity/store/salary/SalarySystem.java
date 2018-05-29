package com.mry.entity.store.salary;


import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2018/1/15.
 * 薪资制度
 */
@ApiModel(value="薪资制度",description="薪资制度")
@Entity
@Table(name = SalarySystem.TABLE_NAME)
public class SalarySystem extends BaseEntity {

    public static final String TABLE_NAME = "salary_system";

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    @Column(name = "store_id")
    private Long storeId;

    //底薪类型(1按月现金总量;2按月客流总量;3按月实操总量;4按月项目总数;5按固定底薪;6按员工级别底薪)
  //  @ApiModelProperty(value="底薪类型(1按月现金总量;2按月客流总量;3按月实操总量;4按月项目总数;5按固定底薪;6按员工级别底薪)",name="typeOfBaseSalary")
    @Column(name = "type_of_base_salary")
    private String typeOfBaseSalary;

        //类型
    @ApiModelProperty(value="类型",name="monthlyCashType")
    @Column(name = "monthly_cash_type")
    private String monthlyCashType;


    //底薪金额
    @ApiModelProperty(value="底薪金额",name="baseSalary")
    @Column(name = "base_salary")
    private BigDecimal baseSalary;


//    //月现金总量
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<MonthlyCashVolume> monthlyCashVolume;
//
//    //月客流总量
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<TotalMonthlyPassengerFlow> totalMonthlyPassengerFlow;
//
//    //月实操总量
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<TotalMonthlyExercise> totalMonthlyExercise;
//
//    //月项目总数
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<TotalMonthlyProject> totalMonthlyProject;
//
//    //员工级别底薪
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<StaffLevelBaseSalary> staffLevelBaseSalary;

    //实操提成
    @ApiModelProperty(value="实操提成",name="practicalExercises")
    @Column(name = "practical_exercises")
    private boolean practicalExercises;

//    //实操提成
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<PracticalExercise> practicalExercise;
//
    //业绩提成
    @ApiModelProperty(value="业绩提成",name="performanceDrawinges")
    @Column(name = "performance_drawinges")
    private boolean performanceDrawinges;
//    //业绩提成
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<PerformanceDrawing> performanceDrawing;


    //手工费
    @ApiModelProperty(value="手工费",name="manualFee")
    @Column(name = "manual_fee")
    private boolean manualFee;

    //奖金类型(1按客流奖励;2按现金业绩奖励;3按实操奖励)
    @ApiModelProperty(value="奖金类型(1按客流奖励;2按现金业绩奖励;3按实操奖励)",name="typeOfBonus")
    @Column(name = "type_of_bonus")
    private String typeOfBonus;

    //单日客流
    @ApiModelProperty(value="单日客流",name="singleDayPassengerFlow")
    @Column(name = "single_day_passenger_flow")
    private Integer singleDayPassengerFlow;

    //单日客流奖励
    @ApiModelProperty(value="单日客流奖励",name="oneDayPassengerFlowAward")
    @Column(name = "one_day_passenger_flow_award")
    private BigDecimal oneDayPassengerFlowAward;

    //累计客流
    @ApiModelProperty(value="单日客流奖励",name="accumulativePassengerFlow")
    @Column(name = "accumulative_passenger_flow")
    private Integer accumulativePassengerFlow;

    //累计客流奖励
    @ApiModelProperty(value="单日客流奖励",name="accumulativePassengerFlowAward")
    @Column(name = "accumulative_passenger_flow_award")
    private BigDecimal accumulativePassengerFlowAward;

    //累计客流
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<AccumulativePassengerFlow> accumulativePassengerFlow;

    //现金业绩奖励
    @ApiModelProperty(value="单日客流奖励",name="cashRewards")
    @Column(name = "cash_Rewards")
    private boolean cashRewards;

        //类型
    @ApiModelProperty(value="类型",name="cashType")
    @Column(name = "cash_type")
    private String cashType;

    //现金业绩奖励
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<CashReward> cashReward;

    //实操奖励
    @ApiModelProperty(value="单日客流奖励",name="practiceRewards")
    @Column(name = "practice_rewards")
    private boolean practiceRewards;

    //实操奖励
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<PracticeReward> practiceReward;

    //团队奖金
    @ApiModelProperty(value="单日客流奖励",name="teamBonuses")
    @Column(name = "team_bonuses")
    private boolean teamBonuses;

    //团队奖金
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<TeamBonus> teamBonus;

    //活动奖金
    @ApiModelProperty(value="单日客流奖励",name="activityBonuses")
    @Column(name = "activity_bonuses")
    private boolean activityBonuses;

    //活动奖金
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<ActivityBonus> activityBonus;

    //投诉罚金
    @ApiModelProperty(value="单日客流奖励",name="complaintFines")
    @Column(name = "complaint_fines")
    private boolean complaintFines;

    //投诉罚金
    @ApiModelProperty(value="单日客流奖励",name="complaintFinesAmount")
    @Column(name = "complaint_fines_amount")
    private BigDecimal complaintFinesAmount;

    //迟到早退罚金
    @ApiModelProperty(value="单日客流奖励",name="leaveEarlyFines")
    @Column(name = "leave_early_fines")
    private boolean leaveEarlyFines;

    //迟到早退罚金
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<LeaveEarlyFines> leaveEarlyFines;

    //事假罚金
    @ApiModelProperty(value="事假罚金",name="leaveAfine")
    @Column(name = "leave_afine")
    private boolean leaveAfine;

    //事假罚金类型(1固定罚金;2按计算规则罚金)
    @ApiModelProperty(value="事假罚金类型(1固定罚金;2按计算规则罚金))",name="typeOfLeave")
    @Column(name = "type_of_leave")
    private String typeOfLeave;

    //事假罚金
    @ApiModelProperty(value="固定罚金金额",name="leaveThePenaltyRules")
    @Column(name = "leave_the_penalty_rules")
    private BigDecimal leaveThePenaltyRules;

    //事假罚金
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<LeaveAfine> leaveAfine;

    //旷工罚金
    @ApiModelProperty(value="旷工罚金",name="absenteeismFine")
    @Column(name = "absenteeism_fine")
    private boolean absenteeismFine;

    //旷工罚金
    @ApiModelProperty(value="旷工罚金",name="absenteeismFineAmount")
    @Column(name = "absenteeism_fine_amount")
    private BigDecimal absenteeismFineAmount;

    //现金业绩罚金
    @ApiModelProperty(value="现金业绩罚金",name="cashPerformancePpenalty")
    @Column(name = "cash_performance_penalty")
    private boolean cashPerformancePpenalty;

    //现金业绩罚金
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<CashPerformancePenalty> cashPerformancePpenalty;

    //客流罚金
    @ApiModelProperty(value="客流罚金",name="passengerFines")
    @Column(name = "passenger_fines")
    private boolean passengerFines;

    //客流罚金
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<PassengerFines> passengerFines;

    //消耗罚金
    @ApiModelProperty(value="消耗罚金",name="consumptionPenalty")
    @Column(name = "consumption_penalty")
    private boolean consumptionPenalty;

    //消耗罚金
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarySystem", fetch = FetchType.LAZY)
//    private List<ConsumptionPenalty> consumptionPenalty;

    //其他罚金
    @ApiModelProperty(value="其他罚金",name="otherFines")
    @Column(name = "other_fines")
    private boolean otherFines;



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

    public boolean isPracticalExercises() {
        return practicalExercises;
    }

    public void setPracticalExercises(boolean practicalExercises) {
        this.practicalExercises = practicalExercises;
    }

    public boolean isPerformanceDrawinges() {
        return performanceDrawinges;
    }

    public void setPerformanceDrawinges(boolean performanceDrawinges) {
        this.performanceDrawinges = performanceDrawinges;
    }

    public boolean isManualFee() {
        return manualFee;
    }

    public void setManualFee(boolean manualFee) {
        this.manualFee = manualFee;
    }

    public String getTypeOfBonus() {
        return typeOfBonus;
    }

    public void setTypeOfBonus(String typeOfBonus) {
        this.typeOfBonus = typeOfBonus;
    }

    public Integer getSingleDayPassengerFlow() {
        return singleDayPassengerFlow;
    }

    public void setSingleDayPassengerFlow(Integer singleDayPassengerFlow) {
        this.singleDayPassengerFlow = singleDayPassengerFlow;
    }

    public BigDecimal getOneDayPassengerFlowAward() {
        return oneDayPassengerFlowAward;
    }

    public void setOneDayPassengerFlowAward(BigDecimal oneDayPassengerFlowAward) {
        this.oneDayPassengerFlowAward = oneDayPassengerFlowAward;
    }

    public Integer getAccumulativePassengerFlow() {
        return accumulativePassengerFlow;
    }

    public void setAccumulativePassengerFlow(Integer accumulativePassengerFlow) {
        this.accumulativePassengerFlow = accumulativePassengerFlow;
    }

    public BigDecimal getAccumulativePassengerFlowAward() {
        return accumulativePassengerFlowAward;
    }

    public void setAccumulativePassengerFlowAward(BigDecimal accumulativePassengerFlowAward) {
        this.accumulativePassengerFlowAward = accumulativePassengerFlowAward;
    }

    public boolean isCashRewards() {
        return cashRewards;
    }

    public void setCashRewards(boolean cashRewards) {
        this.cashRewards = cashRewards;
    }

    public boolean isPracticeRewards() {
        return practiceRewards;
    }

    public void setPracticeRewards(boolean practiceRewards) {
        this.practiceRewards = practiceRewards;
    }

    public boolean isTeamBonuses() {
        return teamBonuses;
    }

    public void setTeamBonuses(boolean teamBonuses) {
        this.teamBonuses = teamBonuses;
    }

    public boolean isActivityBonuses() {
        return activityBonuses;
    }

    public void setActivityBonuses(boolean activityBonuses) {
        this.activityBonuses = activityBonuses;
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

    public boolean isLeaveAfine() {
        return leaveAfine;
    }

    public void setLeaveAfine(boolean leaveAfine) {
        this.leaveAfine = leaveAfine;
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

    public boolean isPassengerFines() {
        return passengerFines;
    }

    public void setPassengerFines(boolean passengerFines) {
        this.passengerFines = passengerFines;
    }

    public boolean isConsumptionPenalty() {
        return consumptionPenalty;
    }

    public void setConsumptionPenalty(boolean consumptionPenalty) {
        this.consumptionPenalty = consumptionPenalty;
    }

    public boolean isOtherFines() {
        return otherFines;
    }

    public void setOtherFines(boolean otherFines) {
        this.otherFines = otherFines;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getCashType() {
        return cashType;
    }

    public void setCashType(String cashType) {
        this.cashType = cashType;
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
