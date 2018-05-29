package com.mry.json.system;

import com.mry.entity.store.salary.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2018/1/19.
 */
public class SalaryOtherJson {


    //实操提成
    private boolean practicalExercises;

    //    //实操提成
    private List<PracticalExercise> practicalExercise;

    //业绩提成
    private boolean performanceDrawinges;
//    //业绩提成
    private List<PerformanceDrawing> performanceDrawing;


    //手工费
    private boolean manualFee;

    //团队奖金
    private boolean teamBonuses;

    //团队奖金
    private List<TeamBonus> teamBonus;

    //活动奖金
    private boolean activity_Bonuses;

    //活动奖金
    private List<ActivityBonus> activityBonus;

    //投诉罚金
    private boolean complaintFines;

    //投诉罚金
    private BigDecimal complaintFinesAmount;

    //迟到早退罚金
    private boolean leaveEarlyFines;

    //迟到早退罚金s
    private List<LeaveEarlyFines> leaveEarlyFiness;

    //事假罚金
    private boolean leaveAfines;

    //事假罚金
    private List<LeaveAfine> leaveAfine;

    //旷工罚金
    private boolean absenteeismFine;

    //旷工罚金
    private BigDecimal absenteeismFineAmount;

    //现金业绩罚金
    private boolean cashPerformancePpenalty;

    //现金业绩罚金
    private List<CashPerformancePenalty> cashPerformancePpenaltyes;

    //客流罚金
    private boolean passengerFines;

    //客流罚金
    private List<PassengerFines> passengerFiness;

    //消耗罚金
    private boolean consumptionPenalty;

    //消耗罚金
    private List<ConsumptionPenalty> consumptionPenaltyes;

    //其他罚金
    private boolean otherFines;

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

    public boolean isActivity_Bonuses() {
        return activity_Bonuses;
    }

    public void setActivity_Bonuses(boolean activity_Bonuses) {
        this.activity_Bonuses = activity_Bonuses;
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

    public boolean isLeaveAfines() {
        return leaveAfines;
    }

    public void setLeaveAfines(boolean leaveAfines) {
        this.leaveAfines = leaveAfines;
    }

    public List<LeaveAfine> getLeaveAfine() {
        return leaveAfine;
    }

    public void setLeaveAfine(List<LeaveAfine> leaveAfine) {
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
}
