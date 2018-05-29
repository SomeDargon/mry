package com.mry.resources.system;

import com.mry.entity.store.salary.*;
import com.mry.json.StatusJson;
import com.mry.json.system.*;
import com.mry.resources.BaseResource;
import com.mry.service.system.SalarySystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by kaik on 2018/1/15.
 * 薪资制度
 */
@Api(description="薪资制度", value = "薪资制度")
@Controller
@RequestMapping("/app/api/salary")
public class SalarySystemResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(SalarySystemResource.class);

    @Resource
    private SalarySystemService salarySystemService;

    /**
     * 保存月现金总量
     *
     * @param data
     */
    @ApiOperation(value = "保存月现金总量")
    @RequestMapping(value = "/editMonthlyCashVolume", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editMonthlyCashVolume(
            @RequestBody MonthlyCashVolume data) {
        StatusJson s =salarySystemService.editMonthlyCashVolume(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，月现金总量")
    @RequestMapping(value = "/editMonthlyCashVolumeStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editMonthlyCashVolumeStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editMonthlyCashVolumeStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，月现金总量")
    @RequestMapping(value = "/deleteMonthlyCashVolume", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteMonthlyCashVolume(
            @RequestParam("id") Long id) {

        salarySystemService.deleteMonthlyCashVolume(id);
    }

    /**
     * 保存员工级别底薪
     *
     * @param data
     */
    @ApiOperation(value = "保存员工级别底薪")
    @RequestMapping(value = "/editStaffLevelBaseSalary", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editStaffLevelBaseSalary(
            @RequestBody StaffLevelBaseSalary data) {
        StatusJson s =salarySystemService.editStaffLevelBaseSalary(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，保存员工级别底薪")
    @RequestMapping(value = "/editStaffLevelBaseSalaryStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editStaffLevelBaseSalaryStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editStaffLevelBaseSalaryStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，保存员工级别底薪")
    @RequestMapping(value = "/deleteStaffLevelBaseSalary", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteStaffLevelBaseSalary(
            @RequestParam("id") Long id) {

        salarySystemService.deleteStaffLevelBaseSalary(id);
    }

    /**
     * 保存月实操总量
     *
     * @param data
     */
    @ApiOperation(value = "保存月实操总量")
    @RequestMapping(value = "/editTotalMonthlyExercise", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editTotalMonthlyExercise(
            @RequestBody TotalMonthlyExercise data) {
        StatusJson s =salarySystemService.editTotalMonthlyExercise(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，月实操总量")
    @RequestMapping(value = "/editTotalMonthlyExerciseStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editTotalMonthlyExerciseStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editTotalMonthlyExerciseStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，月实操总量")
    @RequestMapping(value = "/deleteTotalMonthlyExercise", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteTotalMonthlyExercise(
            @RequestParam("id") Long id) {

        salarySystemService.deleteTotalMonthlyExercise(id);
    }

    /**
     * 保存月客流总量
     *
     * @param data
     */
    @ApiOperation(value = "保存月客流总量")
    @RequestMapping(value = "/editTotalMonthlyPassengerFlow", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editTotalMonthlyPassengerFlow(
            @RequestBody TotalMonthlyPassengerFlow data) {
        StatusJson s =salarySystemService.editTotalMonthlyPassengerFlow(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，月客流总量")
    @RequestMapping(value = "/editTotalMonthlyPassengerFlowStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editTotalMonthlyPassengerFlowStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editTotalMonthlyPassengerFlowStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，月客流总量")
    @RequestMapping(value = "/deleteTotalMonthlyPassengerFlow", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteTotalMonthlyPassengerFlow(
            @RequestParam("id") Long id) {
        salarySystemService.deleteTotalMonthlyPassengerFlow(id);
    }


    /**
     * 保存月项目总数
     *
     * @param data
     */
    @ApiOperation(value = "保存月项目总数")
    @RequestMapping(value = "/editTotalMonthlyProject", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editTotalMonthlyProject(
            @RequestBody TotalMonthlyProject data) {
        StatusJson s =salarySystemService.editTotalMonthlyProject(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，月项目总数")
    @RequestMapping(value = "/editTotalMonthlyProjectStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editTotalMonthlyProjectStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editTotalMonthlyProjectStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，月项目总数")
    @RequestMapping(value = "/deleteTotalMonthlyProject", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteTotalMonthlyProject(
            @RequestParam("id") Long id) {
        salarySystemService.deleteTotalMonthlyProject(id);
    }

    /**
     * 保存实操提成
     *
     * @param data
     */
    @ApiOperation(value = "保存实操提成")
    @RequestMapping(value = "/editPracticalExercise", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editPracticalExercise(
            @RequestBody PracticalExercise data) {
        StatusJson s =salarySystemService.editPracticalExercise(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，实操提成")
    @RequestMapping(value = "/editPracticalExerciseStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editPracticalExerciseStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editPracticalExerciseStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，实操提成")
    @RequestMapping(value = "/deletePracticalExercise", method = RequestMethod.GET)
    public
    @ResponseBody
    void deletePracticalExercise(
            @RequestParam("id") Long id) {
        salarySystemService.deletePracticalExercise(id);
    }


    /**
     * 保存业绩提成
     *
     * @param data
     */
    @ApiOperation(value = "保存业绩提成")
    @RequestMapping(value = "/editPerformanceDrawing", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editPerformanceDrawing(
            @RequestBody PerformanceDrawing data) {
        StatusJson s =salarySystemService.editPerformanceDrawing(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，业绩提成")
    @RequestMapping(value = "/editPerformanceDrawingStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editPerformanceDrawingStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editPerformanceDrawingStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，业绩提成")
    @RequestMapping(value = "/deletePerformanceDrawing", method = RequestMethod.GET)
    public
    @ResponseBody
    void deletePerformanceDrawing(
            @RequestParam("id") Long id) {
        salarySystemService.deletePerformanceDrawing(id);
    }

    /**
     * 累计客流区间奖励
     *
     * @param data
     */
    @ApiOperation(value = "保存累计客流区间奖励")
    @RequestMapping(value = "/editAccumulativePassengerFlow", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editAccumulativePassengerFlow(
            @RequestBody AccumulativePassengerFlow data) {
        StatusJson s =salarySystemService.editAccumulativePassengerFlow(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，累计客流区间奖励")
    @RequestMapping(value = "/editAccumulativePassengerFlowStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editAccumulativePassengerFlowStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editAccumulativePassengerFlowStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，累计客流区间奖励")
    @RequestMapping(value = "/deleteAccumulativePassengerFlow", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteAccumulativePassengerFlow(
            @RequestParam("id") Long id) {
        salarySystemService.deleteAccumulativePassengerFlow(id);
    }

    /**
     * 现金业绩奖励
     *
     * @param data
     */
    @ApiOperation(value = "保存现金业绩奖励")
    @RequestMapping(value = "/editCashReward", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editCashReward(
            @RequestBody CashReward data) {
        StatusJson s =salarySystemService.editCashReward(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，现金业绩奖励")
    @RequestMapping(value = "/editCashRewardStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editCashRewardStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editCashRewardStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，现金业绩奖励")
    @RequestMapping(value = "/deleteCashReward", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteCashReward(
            @RequestParam("id") Long id) {
        salarySystemService.deleteCashReward(id);
    }


    /**
     * 实操奖励
     *
     * @param data
     */
    @ApiOperation(value = "保存实操奖励")
    @RequestMapping(value = "/editPracticeReward", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editPracticeReward(
            @RequestBody PracticeReward data) {
        StatusJson s =salarySystemService.editPracticeReward(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，实操奖励")
    @RequestMapping(value = "/editPracticeRewardStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editPracticeRewardStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editPracticeRewardStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，实操奖励")
    @RequestMapping(value = "/deletePracticeReward", method = RequestMethod.GET)
    public
    @ResponseBody
    void deletePracticeReward(
            @RequestParam("id") Long id) {
        salarySystemService.deletePracticeReward(id);
    }

    /**
     * 团队奖金
     *
     * @param data
     */
    @ApiOperation(value = "保存团队奖金")
    @RequestMapping(value = "/editTeamBonus", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editTeamBonus(
            @RequestBody TeamBonus data) {
        StatusJson s =salarySystemService.editTeamBonus(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，团队奖金")
    @RequestMapping(value = "/editTeamBonusStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editTeamBonusStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editTeamBonusStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，团队奖金")
    @RequestMapping(value = "/deleteTeamBonus", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteTeamBonus(
            @RequestParam("id") Long id) {
        salarySystemService.deleteTeamBonus(id);
    }

    /**
     * 活动奖金
     *
     * @param data
     */
    @ApiOperation(value = "保存活动奖金")
    @RequestMapping(value = "/editActivityBonus", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editActivityBonus(
            @RequestBody ActivityBonus data) {
        StatusJson s =salarySystemService.editActivityBonus(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，活动奖金")
    @RequestMapping(value = "/editActivityBonusStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editActivityBonusStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editActivityBonusStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，活动奖金")
    @RequestMapping(value = "/deleteActivityBonus", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteActivityBonus(
            @RequestParam("id") Long id) {
        salarySystemService.deleteActivityBonus(id);
    }

    /**
     * 迟到早退罚金
     *
     * @param data
     */
    @ApiOperation(value = "保存迟到早退罚金")
    @RequestMapping(value = "/editLeaveEarlyFines", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editLeaveEarlyFines(
            @RequestBody LeaveEarlyFines data) {
        StatusJson s =salarySystemService.editLeaveEarlyFines(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，迟到早退罚金")
    @RequestMapping(value = "/editLeaveEarlyFinesStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editLeaveEarlyFinesStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editLeaveEarlyFinesStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，迟到早退罚金")
    @RequestMapping(value = "/deleteLeaveEarlyFines", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteLeaveEarlyFines(
            @RequestParam("id") Long id) {
        salarySystemService.deleteLeaveEarlyFines(id);
    }

    /**
     * 事假罚金
     *
     * @param data
     */
    @ApiOperation(value = "保存事假罚金")
    @RequestMapping(value = "/editLeaveAfine", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editLeaveAfine(
            @RequestBody LeaveAfine data) {
        StatusJson s =salarySystemService.editLeaveAfine(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，事假罚金")
    @RequestMapping(value = "/editLeaveAfineStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editLeaveAfineStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editLeaveAfineStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，事假罚金")
    @RequestMapping(value = "/deleteLeaveAfine", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteLeaveAfine(
            @RequestParam("id") Long id) {
        salarySystemService.deleteLeaveAfine(id);
    }

    /**
     * 现金业绩罚金
     *
     * @param data
     */
    @ApiOperation(value = "保存现金业绩罚金")
    @RequestMapping(value = "/editCashPerformancePpenalty", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editCashPerformancePpenalty(
            @RequestBody CashPerformancePenalty data) {
        StatusJson s =salarySystemService.editCashPerformancePpenalty(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，现金业绩罚金")
    @RequestMapping(value = "/editCashPerformancePpenaltyStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editCashPerformancePpenaltyStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editCashPerformancePpenaltyStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，现金业绩罚金")
    @RequestMapping(value = "/deleteCashPerformancePpenalty", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteCashPerformancePpenalty(
            @RequestParam("id") Long id) {
        salarySystemService.deleteCashPerformancePpenalty(id);
    }

    /**
     * 客流罚金
     *
     * @param data
     */
    @ApiOperation(value = "保存客流罚金")
    @RequestMapping(value = "/editPassengerFines", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editPassengerFines(
            @RequestBody PassengerFines data) {
        StatusJson s =salarySystemService.editPassengerFines(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，客流罚金")
    @RequestMapping(value = "/editPassengerFinesStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editPassengerFinesStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editPassengerFinesStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，客流罚金")
    @RequestMapping(value = "/deletePassengerFines", method = RequestMethod.GET)
    public
    @ResponseBody
    void deletePassengerFines(
            @RequestParam("id") Long id) {
        salarySystemService.deletePassengerFines(id);
    }

    /**
     * 消耗罚金
     *
     * @param data
     */
    @ApiOperation(value = "保存消耗罚金")
    @RequestMapping(value = "/editConsumptionPenalty", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editConsumptionPenalty(
            @RequestBody ConsumptionPenalty data) {
        StatusJson s =salarySystemService.editConsumptionPenalty(data);
        return s;
    }

    /**
     * 修改启用状态
     * @param id
     */
    @ApiOperation(value = "修改启用状态，消耗罚金")
    @RequestMapping(value = "/editConsumptionPenaltyStatus", method = RequestMethod.GET)
    public  @ResponseBody
    StatusJson editConsumptionPenaltyStatus(
            @RequestParam("disable") boolean disable,
            @RequestParam("id") Long id) {
        StatusJson s =salarySystemService.editConsumptionPenaltyStatus(disable,id);
        return s;
    }

    /**
     * 删除（只是变成不启用转台）
     * @param id
     */
    @ApiOperation(value = "删除，消耗罚金")
    @RequestMapping(value = "/deleteConsumptionPenalty", method = RequestMethod.GET)
    public
    @ResponseBody
    void deleteConsumptionPenalty(
            @RequestParam("id") Long id) {
        salarySystemService.deleteConsumptionPenalty(id);
    }
    /**
     * 保存底薪
     *
     * @param data
     */
    @ApiOperation(value = "保存底薪")
    @RequestMapping(value = "/editSalarySystem", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editSalarySystem(
            @RequestBody SalarySystem data) {
        StatusJson s =salarySystemService.editSalarySystem(data);
        return s;
    }

    /**
     * 查询底薪
     * @param id
     */
    @ApiOperation(value = "查询底薪")
    @RequestMapping(value = "/findByStore", method = RequestMethod.GET)
    public  @ResponseBody
    SalaryBaseJson findByStore(
            @RequestParam(value = "typeOfBaseSalary" , required = false) String typeOfBaseSalary,
            @RequestParam("id") Long id) {
        SalaryBaseJson s =salarySystemService.findByStore(typeOfBaseSalary,id);
        return s;
    }

    /**
     * 查询薪资
     * @param id
     */
    @ApiOperation(value = "查询薪资")
    @RequestMapping(value = "/findSalaryByStore", method = RequestMethod.GET)
    public  @ResponseBody
    SalarySystemJson findSalaryByStore(
            @RequestParam("id") Long id) {
        SalarySystemJson s =salarySystemService.findSalaryByStore(id);
        return s;
    }

    /**
     * 查询奖金
     * @param id
     */
    @ApiOperation(value = "查询奖金")
    @RequestMapping(value = "/findBonusesJsonByStore", method = RequestMethod.GET)
    public  @ResponseBody
    BonusesJson findBonusesJsonByStore(
            @RequestParam(value = "typeOfBonus" , required = false) String typeOfBonus,
            @RequestParam("id") Long id) {
        BonusesJson s =salarySystemService.findBonusesJsonByStore(id,typeOfBonus);
        return s;
    }

    /**
     * 保存客流奖励
     *
     * @param data
     */
    @ApiOperation(value = "保存客流奖励")
    @RequestMapping(value = "/editPassengerFlowAwardJson", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editPassengerFlowAwardJson(
            @RequestBody PassengerFlowAwardJson data) {
        StatusJson s =salarySystemService.editPassengerFlowAwardJson(data);
        return s;
    }

    /**
     * 保存客流奖励
     *
     * @param data
     */
    @ApiOperation(value = "保存客流奖励")
    @RequestMapping(value = "/editFineJson", method = RequestMethod.POST)
    public  @ResponseBody
    StatusJson editFineJson(
            @RequestBody FineJson data) {
        StatusJson s =salarySystemService.editFineJson(data);
        return s;
    }

    @ApiOperation(value = "下载工资条")
    @RequestMapping(value = "/downloadMoney", method = RequestMethod.POST)
    public  @ResponseBody
    void downloadMoney(
            @RequestParam Long data, @RequestParam Long staffId) {
        salarySystemService.downloadSalary(data, staffId);
    }




}
