package com.mry.service.system;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.system.SalarySystemDao;
import com.mry.entity.store.attendance.Attendance;
import com.mry.entity.store.attendance.BusinessDate;
import com.mry.entity.store.salary.*;
import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.json.StatusJson;
import com.mry.json.system.*;
import com.mry.service.BaseService;
import com.mry.service.attendance.AttendanceService;
import com.mry.service.attendance.BusinessDateService;
import com.mry.service.store.ServiceOrdersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2018/1/15.
 */
@Service
@Transactional
public class SalarySystemService extends BaseService {

    @Resource
    public SalarySystemDao salarySystemDao;
    @Resource
    public StoreDao storeDao;

    public StatusJson editMonthlyCashVolume(MonthlyCashVolume data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            MonthlyCashVolume m = salarySystemDao.findMonthlyCashVolumeById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }



    public StatusJson editMonthlyCashVolumeStatus(boolean disable, Long id) {

        MonthlyCashVolume m = salarySystemDao.findMonthlyCashVolumeById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteMonthlyCashVolume(Long id) {
        salarySystemDao.deleteMonthlyCashVolume(id);
    }

    public StatusJson editStaffLevelBaseSalary(StaffLevelBaseSalary data) {

        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            StaffLevelBaseSalary m = salarySystemDao.findStaffLevelBaseSalaryById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editStaffLevelBaseSalaryStatus(boolean disable, Long id) {
        StaffLevelBaseSalary m = salarySystemDao.findStaffLevelBaseSalaryById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteStaffLevelBaseSalary(Long id) {
        salarySystemDao.deleteStaffLevelBaseSalary(id);
    }

    public StatusJson editTotalMonthlyExercise(TotalMonthlyExercise data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            TotalMonthlyExercise m = salarySystemDao.findTotalMonthlyExerciseById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editTotalMonthlyExerciseStatus(boolean disable, Long id) {
        TotalMonthlyExercise m = salarySystemDao.findTotalMonthlyExerciseById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteTotalMonthlyExercise(Long id) {
        salarySystemDao.deleteTotalMonthlyExercise(id);
    }

    public StatusJson editTotalMonthlyPassengerFlow(TotalMonthlyPassengerFlow data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            TotalMonthlyPassengerFlow m = salarySystemDao.findTotalMonthlyPassengerFlowById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editTotalMonthlyPassengerFlowStatus(boolean disable, Long id) {
        TotalMonthlyPassengerFlow m = salarySystemDao.findTotalMonthlyPassengerFlowById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteTotalMonthlyPassengerFlow(Long id) {
        salarySystemDao.deleteTotalMonthlyPassengerFlow(id);
    }

    public StatusJson editTotalMonthlyProject(TotalMonthlyProject data) {

        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            TotalMonthlyProject m = salarySystemDao.findTotalMonthlyProjectById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editTotalMonthlyProjectStatus(boolean disable, Long id) {
        TotalMonthlyProject m = salarySystemDao.findTotalMonthlyProjectById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteTotalMonthlyProject(Long id) {
        salarySystemDao.deleteTotalMonthlyProject(id);
    }



    public StatusJson editSalarySystem(SalarySystem data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();

        if(data.getId() != null) {
            SalarySystem sa = salarySystemDao.findById(data.getId());

            sta.setMessage("修改成功");
            sta.setStatus(1);
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);

        }
        salarySystemDao.updateObject(data);
        return sta;
    }

    public StatusJson editPracticalExercise(PracticalExercise data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            PracticalExercise m = salarySystemDao.findPracticalExerciseById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editPracticalExerciseStatus(boolean disable, Long id) {
        PracticalExercise m = salarySystemDao.findPracticalExerciseById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deletePracticalExercise(Long id) {
        salarySystemDao.deletePracticalExercise(id);
    }

    public StatusJson editPerformanceDrawing(PerformanceDrawing data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            PerformanceDrawing m = salarySystemDao.findPerformanceDrawingById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editPerformanceDrawingStatus(boolean disable, Long id) {
        PerformanceDrawing m = salarySystemDao.findPerformanceDrawingById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deletePerformanceDrawing(Long id) {
        salarySystemDao.deletePerformanceDrawing(id);
    }

    public StatusJson editAccumulativePassengerFlow(AccumulativePassengerFlow data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            AccumulativePassengerFlow m = salarySystemDao.findAccumulativePassengerFlowById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editAccumulativePassengerFlowStatus(boolean disable, Long id) {
        AccumulativePassengerFlow m = salarySystemDao.findAccumulativePassengerFlowById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }


    public void deleteAccumulativePassengerFlow(Long id) {
        salarySystemDao.deleteAccumulativePassengerFlow(id);
    }

    public StatusJson editCashReward(CashReward data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            CashReward m = salarySystemDao.findCashRewardById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editCashRewardStatus(boolean disable, Long id) {
        CashReward m = salarySystemDao.findCashRewardById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteCashReward(Long id) {
        salarySystemDao.deleteCashReward(id);
    }

    public StatusJson editPracticeReward(PracticeReward data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            PracticeReward m = salarySystemDao.findPracticeRewardById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editPracticeRewardStatus(boolean disable, Long id) {
        PracticeReward m = salarySystemDao.findPracticeRewardById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deletePracticeReward(Long id) {
        salarySystemDao.deletePracticeReward(id);
    }

    public StatusJson editTeamBonus(TeamBonus data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            TeamBonus m = salarySystemDao.findTeamBonusById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editTeamBonusStatus(boolean disable, Long id) {
        TeamBonus m = salarySystemDao.findTeamBonusById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteTeamBonus(Long id) {
        salarySystemDao.deleteTeamBonus(id);
    }

    public StatusJson editActivityBonus(ActivityBonus data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            ActivityBonus m = salarySystemDao.findActivityBonusById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editActivityBonusStatus(boolean disable, Long id) {
        ActivityBonus m = salarySystemDao.findActivityBonusById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteActivityBonus(Long id) {
        salarySystemDao.deleteActivityBonus(id);
    }

    public StatusJson editLeaveEarlyFines(LeaveEarlyFines data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            LeaveEarlyFines m = salarySystemDao.findLeaveEarlyFinesById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editLeaveEarlyFinesStatus(boolean disable, Long id) {
        LeaveEarlyFines m = salarySystemDao.findLeaveEarlyFinesById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteLeaveEarlyFines(Long id) {
        salarySystemDao.deleteLeaveEarlyFines(id);
    }

    public StatusJson editLeaveAfine(LeaveAfine data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            LeaveAfine m = salarySystemDao.findLeaveAfineById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editLeaveAfineStatus(boolean disable, Long id) {
        LeaveAfine m = salarySystemDao.findLeaveAfineById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteLeaveAfine(Long id) {
        salarySystemDao.deleteLeaveAfine(id);
    }

    public StatusJson editCashPerformancePpenalty(CashPerformancePenalty data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            CashPerformancePenalty m = salarySystemDao.findCashPerformancePpenaltyById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editCashPerformancePpenaltyStatus(boolean disable, Long id) {
        CashPerformancePenalty m = salarySystemDao.findCashPerformancePpenaltyById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteCashPerformancePpenalty(Long id) {
        salarySystemDao.deleteCashPerformancePpenalty(id);
    }

    public StatusJson editPassengerFines(PassengerFines data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            PassengerFines m = salarySystemDao.findPassengerFinesById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editPassengerFinesStatus(boolean disable, Long id) {
        PassengerFines m = salarySystemDao.findPassengerFinesById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deletePassengerFines(Long id) {
        salarySystemDao.deletePassengerFines(id);
    }

    public StatusJson editConsumptionPenalty(ConsumptionPenalty data) {
        StoreManagement s = storeDao.findById(data.getStoreId());
        data.setEnable(true);
        data.setDisable(true);
        data.setStoreName(s.getStoreName());
        StatusJson sta = new StatusJson();
        salarySystemDao.updateObject(data);
        if(data.getId() != null) {
            ConsumptionPenalty m = salarySystemDao.findConsumptionPenaltyById(data.getId());
            if(m != null){
                sta.setMessage("修改成功");
                sta.setStatus(1);
            }
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editConsumptionPenaltyStatus(boolean disable, Long id) {
        ConsumptionPenalty m = salarySystemDao.findConsumptionPenaltyById(id);
        m.setDisable(disable);
        salarySystemDao.updateObject(m);
        StatusJson sta = new StatusJson();
        sta.setMessage("修改成功");
        sta.setStatus(1);
        return sta;
    }

    public void deleteConsumptionPenalty(Long id) {
        salarySystemDao.deleteConsumptionPenalty(id);
    }

    public SalaryBaseJson findByStore(String typeOfBaseSalary, Long id) {
          SalarySystem sa = salarySystemDao.findByStoreId(id);
        StoreManagement s = storeDao.findById(id);
        SalaryBaseJson json = new SalaryBaseJson();
        // json.setId(s.getId());
        json.setStoreId(s.getId());
        json.setStoreName(s.getStoreName());
        //   json.setTypeOfBaseSalary(typeOfBaseSalary);
        int type=0;
        if(sa != null){
            json.setId(sa.getId());
        }
        if(typeOfBaseSalary != null) {
             type = Integer.valueOf(typeOfBaseSalary);
            json.setTypeOfBaseSalary(typeOfBaseSalary);
        }else if(sa != null&&sa.getTypeOfBaseSalary() != null){
            type = Integer.valueOf(sa.getTypeOfBaseSalary());
            json.setTypeOfBaseSalary(sa.getTypeOfBaseSalary());
        }else {
            type =5;
            sa.setTypeOfBaseSalary("5");
        }
        switch(type)
        {
            case 1:
                //月现金总量
                List<MonthlyCashVolume> monthlyCashVolume = salarySystemDao.findMonthlyCashVolume(id);
                //   json.setMonthlyCashVolume(monthlyCashVolume);
                json.setData(monthlyCashVolume);
                json.setMonthlyCashType(sa.getMonthlyCashType());

                break;
            case 2:
                //月客流总量
                List<TotalMonthlyPassengerFlow> totalMonthlyPassengerFlow = salarySystemDao.findTotalMonthlyPassengerFlow(id);
                //  json.setTotalMonthlyPassengerFlow(totalMonthlyPassengerFlow);
                json.setData(totalMonthlyPassengerFlow);
                json.setMonthlyCashType(sa.getMonthlyCashType());
                break;
            case 3:
                //月实操总量
                List<TotalMonthlyExercise> totalMonthlyExercise = salarySystemDao.findTotalMonthlyExercise(id);
                // json.setTotalMonthlyExercise(totalMonthlyExercise);
                json.setData(totalMonthlyExercise);
                break;
            case 4:
                //月项目总数
                List<TotalMonthlyProject> totalMonthlyProject = salarySystemDao.findTotalMonthlyProject(id);
                //  json.setTotalMonthlyProject(totalMonthlyProject);
                json.setData(totalMonthlyProject);
                break;
            case 5:
                SalarySystem salary = salarySystemDao.findByStoreId(id);
                if(salary != null && salary.getBaseSalary() != null ) {
                    json.setBaseSalary(salary.getBaseSalary());
                }
                break;
            case 6:
                List<StaffLevelBaseSalary> staffLevelBaseSalary = salarySystemDao.findStaffLevelBaseSalary(id);
                //  json.setStaffLevelBaseSalary(staffLevelBaseSalary);
                json.setData(staffLevelBaseSalary);
                break;
        }


        return json;

    }

    public SalarySystemJson findSalaryByStore(Long id) {
        SalarySystem sa = salarySystemDao.findByStoreId(id);
        SalarySystemJson s = new SalarySystemJson();
        if(sa != null) {
            s.setId(sa.getId());
            s.setStoreName(sa.getStoreName());
            s.setStoreId(sa.getStoreId());
            s.setTypeOfBaseSalary(sa.getTypeOfBaseSalary());
            s.setBaseSalary(sa.getBaseSalary());
            s.setMonthlyCashType(sa.getMonthlyCashType());
            s.setPracticalExercises(sa.isPracticalExercises());
            if (sa.isPracticalExercises() == true) {
                List<PracticalExercise> practicalExercise = salarySystemDao.findPracticalExerciseByStoreId(id);
                s.setPracticalExercise(practicalExercise);
            }

            s.setPerformanceDrawinges(sa.isPerformanceDrawinges());
//    //业绩提成
            if (sa.isPerformanceDrawinges() == true) {
                List<PerformanceDrawing> performanceDrawing = salarySystemDao.findPerformanceDrawingByStoreId(id);
                s.setPerformanceDrawing(performanceDrawing);
            }
            //手工费
            s.setManualFee(sa.isManualFee());

            //奖金类型(1按客流奖励;2按现金业绩奖励;3按实操奖励)
            s.setTypeOfBonus(sa.getTypeOfBonus());
            //团队奖金
            s.setTeamBonuses(sa.isTeamBonuses());
            if (sa.isTeamBonuses() == true) {
                List<TeamBonus> teamBonus = salarySystemDao.findTeamBonusByStoreId(id);
                s.setTeamBonus(teamBonus);
            }
            //活动奖金
            s.setActivityBonuses(sa.isActivityBonuses());
            if (sa.isActivityBonuses() == true) {
                List<ActivityBonus> activityBonus = salarySystemDao.findActivityBonusByStoreId(id);
                s.setActivityBonus(activityBonus);
            }
            //投诉罚金
            s.setComplaintFines(sa.isComplaintFines());
            //投诉罚金金额
            s.setComplaintFinesAmount(sa.getComplaintFinesAmount());
            //迟到早退罚金
            s.setLeaveEarlyFines(sa.isLeaveEarlyFines());
            //迟到早退罚金
            if (sa.isLeaveEarlyFines() == true) {
                List<LeaveEarlyFines> leaveEarlyFines = salarySystemDao.findLeaveEarlyFinesByStoreId(id);
                s.setLeaveEarlyFiness(leaveEarlyFines);
            }
            //事假罚金
            s.setLeaveAfine(sa.isLeaveAfine());
            //事假罚金
            if (sa.isLeaveAfine() == true) {
                if(sa.getTypeOfLeave().equals("1")) {
                    s.setLeaveThePenaltyRules(sa.getLeaveThePenaltyRules());
                }else if(sa.getTypeOfLeave().equals("2")) {
                    List<LeaveAfine> leaveAfine = salarySystemDao.findLeaveAfineByStoreId(id);
                    s.setLeaveAfines(leaveAfine);
                }
                s.setTypeOfLeave(sa.getTypeOfLeave());
            }

            //旷工罚金
            s.setAbsenteeismFine(sa.isAbsenteeismFine());

            //旷工罚金金额
            s.setAbsenteeismFineAmount(sa.getAbsenteeismFineAmount());

            //现金业绩罚金
            s.setCashPerformancePpenalty(sa.isCashPerformancePpenalty());
            //现金业绩罚金
            if (sa.isCashPerformancePpenalty() == true) {
                List<CashPerformancePenalty> cashPerformancePpenaltyes = salarySystemDao.findCashPerformancePpenaltyByStoreId(id);
                s.setCashPerformancePpenaltyes(cashPerformancePpenaltyes);
            }
            //客流罚金
            s.setPassengerFines(sa.isPassengerFines());
            //客流罚金
            if (sa.isPassengerFines() == true) {
                List<PassengerFines> passengerFines = salarySystemDao.findPassengerFinesByStoreId(id);
                s.setPassengerFiness(passengerFines);
            }

            //消耗罚金
            s.setConsumptionPenalty(sa.isConsumptionPenalty());

            //消耗罚金
            if (sa.isConsumptionPenalty() == true) {
                List<ConsumptionPenalty> consumptionPenalty = salarySystemDao.findConsumptionPenaltyByStoreId(id);
                s.setConsumptionPenaltyes(consumptionPenalty);
            }
            //其他罚金
            s.setOtherFines(sa.isOtherFines());

            return s;
        }else {
            return s;
        }
    }

    public BonusesJson findBonusesJsonByStore(Long id,String typeOfBonus) {

        SalarySystem sa = salarySystemDao.findByStoreId(id);
        BonusesJson b = new BonusesJson();
        if(sa != null) {
            //奖金类型(1按客流奖励;2按现金业绩奖励;3按实操奖励)
            b.setId(sa.getId());
            b.setTypeOfBonus(sa.getTypeOfBonus());
            int type =0;
            if(typeOfBonus != null) {
                 type = Integer.valueOf(typeOfBonus);
            }else{
                 type = Integer.valueOf(sa.getTypeOfBonus());
            }
            switch (type) {
                case 1:
                    //单日客流
                    b.setSingleDayPassengerFlow(sa.getSingleDayPassengerFlow());

                    //单日客流奖励
                    b.setOneDayPassengerFlowAward(sa.getOneDayPassengerFlowAward());

                    //累计客流
                    b.setAccumulativePassengerFlow(sa.getAccumulativePassengerFlow());

                    //累计客流奖励
                    b.setAccumulativePassengerFlowAward(sa.getAccumulativePassengerFlowAward());

                    List<AccumulativePassengerFlow> accumulativePassengerFlowes = salarySystemDao.findAccumulativePassengerFlowByStoreId(id);
                    //累计客流
                    b.setData(accumulativePassengerFlowes);
                    break;
                case 2:
                    //现金业绩奖励
                    // b.setCashRewards(sa.isCashRewards());
                    //现金业绩奖励
                    // if(sa.isCashRewards() == true) {
                    List<CashReward> cashReward = salarySystemDao.findCashRewardByStoreId(id);
                    b.setCashType(sa.getCashType());
                    b.setData(cashReward);
                    break;
                //  }
                case 3:
                    //实操奖励
                    //   b.setPracticeRewards(sa.isPracticeRewards());
                    //实操奖励
                    // if(sa.isPracticeRewards() == true) {
                    List<PracticeReward> practiceReward = salarySystemDao.findPracticeRewardByStoreId(id);
                    b.setData(practiceReward);
                    break;
            }
            return b;
        }else {
            return b;
        }
    }


    public StatusJson editPassengerFlowAwardJson(PassengerFlowAwardJson data) {
        SalarySystem s = salarySystemDao.findById(data.getId());
        //单日客流

        s.setSingleDayPassengerFlow(data.getSingleDayPassengerFlow());
        //单日客流奖励
        s.setOneDayPassengerFlowAward(data.getOneDayPassengerFlowAward());
        //累计客流
        s.setAccumulativePassengerFlow(data.getAccumulativePassengerFlow());
        //累计客流奖励
        s.setAccumulativePassengerFlowAward(data.getAccumulativePassengerFlowAward());
        salarySystemDao.updateObject(s);
        StatusJson sta = new StatusJson();
        if(data.getId() != null) {
            sta.setMessage("修改成功");
            sta.setStatus(1);
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public StatusJson editFineJson(FineJson data) {
        SalarySystem s = salarySystemDao.findById(data.getId());
        //投诉罚金
        s.setComplaintFinesAmount(data.getComplaintFinesAmount());
        //旷工罚金
        s.setAbsenteeismFineAmount(data.getAbsenteeismFineAmount());
        s.setLeaveThePenaltyRules(data.getLeaveThePenaltyRules());

        salarySystemDao.updateObject(s);
        StatusJson sta = new StatusJson();
        if(data.getId() != null) {
            sta.setMessage("修改成功");
            sta.setStatus(1);
        }else {
            sta.setMessage("保存成功");
            sta.setStatus(1);
        }
        return sta;
    }

    public void downloadSalary(Long id, Long staffId){
        //查询底薪
        SalarySystem sa = salarySystemDao.findByStoreId(id);
        SalaryBaseJson json = new SalaryBaseJson();
        String type = sa.getTypeOfBaseSalary();
        switch(Integer.valueOf(type))
        {
            case 1:
                //月现金总量
                List<MonthlyCashVolume> monthlyCashVolume = salarySystemDao.findMonthlyCashVolume(id);
                //   json.setMonthlyCashVolume(monthlyCashVolume);
                json.setData(monthlyCashVolume);
                json.setMonthlyCashType(sa.getMonthlyCashType());

                break;
            case 2:
                //月客流总量
                List<TotalMonthlyPassengerFlow> totalMonthlyPassengerFlow = salarySystemDao.findTotalMonthlyPassengerFlow(id);
                //  json.setTotalMonthlyPassengerFlow(totalMonthlyPassengerFlow);
                json.setData(totalMonthlyPassengerFlow);
                json.setMonthlyCashType(sa.getMonthlyCashType());
                break;
            case 3:
                //月实操总量
                List<TotalMonthlyExercise> totalMonthlyExercise = salarySystemDao.findTotalMonthlyExercise(id);
                // json.setTotalMonthlyExercise(totalMonthlyExercise);
                json.setData(totalMonthlyExercise);
                break;
            case 4:
                //月项目总数
                List<TotalMonthlyProject> totalMonthlyProject = salarySystemDao.findTotalMonthlyProject(id);
                //  json.setTotalMonthlyProject(totalMonthlyProject);
                json.setData(totalMonthlyProject);
                break;
            case 5:
                SalarySystem salary = salarySystemDao.findByStoreId(id);
                if(salary != null && salary.getBaseSalary() != null ) {
                    json.setBaseSalary(salary.getBaseSalary());
                }
                break;
            case 6:
                List<StaffLevelBaseSalary> staffLevelBaseSalary = salarySystemDao.findStaffLevelBaseSalary(id);
                //  json.setStaffLevelBaseSalary(staffLevelBaseSalary);
                json.setData(staffLevelBaseSalary);
                break;
        }
        //查询服务单
        List<ServiceOrders> serviceOrderses  =  findByService(staffId);

        //查询奖金

        BonusesJson b = new BonusesJson();
        if(sa != null) {
            //奖金类型(1按客流奖励;2按现金业绩奖励;3按实操奖励)
            b.setId(sa.getId());
            b.setTypeOfBonus(sa.getTypeOfBonus());
            type = sa.getTypeOfBonus();
            switch (Integer.valueOf(type)) {
                case 1:
                    //单日客流
                    b.setSingleDayPassengerFlow(sa.getSingleDayPassengerFlow());

                    //单日客流奖励
                    b.setOneDayPassengerFlowAward(sa.getOneDayPassengerFlowAward());

                    //累计客流
                    b.setAccumulativePassengerFlow(sa.getAccumulativePassengerFlow());

                    //累计客流奖励
                    b.setAccumulativePassengerFlowAward(sa.getAccumulativePassengerFlowAward());

                    List<AccumulativePassengerFlow> accumulativePassengerFlowes = salarySystemDao.findAccumulativePassengerFlowByStoreId(id);
                    //累计客流
                    b.setData(accumulativePassengerFlowes);
                    break;
                case 2:
                    //现金业绩奖励
                    // b.setCashRewards(sa.isCashRewards());
                    //现金业绩奖励
                    // if(sa.isCashRewards() == true) {
                    List<CashReward> cashReward = salarySystemDao.findCashRewardByStoreId(id);
                    b.setCashType(sa.getCashType());
                    b.setData(cashReward);
                    break;
                //  }
                case 3:
                    //实操奖励
                    //   b.setPracticeRewards(sa.isPracticeRewards());
                    //实操奖励
                    // if(sa.isPracticeRewards() == true) {
                    List<PracticeReward> practiceReward = salarySystemDao.findPracticeRewardByStoreId(id);
                    b.setData(practiceReward);
                    break;
            }
        }
        //团队奖金
        if (sa.isTeamBonuses() == true) {
            List<TeamBonus> teamBonus = salarySystemDao.findTeamBonusByStoreId(id);
        }
        //活动奖金
        if (sa.isActivityBonuses() == true) {
            List<ActivityBonus> activityBonus = salarySystemDao.findActivityBonusByStoreId(id);
        }
        //罚金
        //矿工
        int absenteeismNum = 0;
        //事假
        int  casualLeaveNum = 0;
        //病假
        int bingNum = 0;
        //出差
        int chuNum =0;
        Date sdate = new Date();
        Date edate = new Date();

        //查询登记记录
        List<Attendance> attendances = attendanceService.findByUserIdAndTime(id, sdate, edate);
        /** 标记 0事假 1病假 2出差 3调休 4离职: */
        for (Attendance a:attendances){
            switch (a.getSign()){
                case 0: casualLeaveNum++;break;
                case 1: bingNum++; break;
                case 2: chuNum++; break;
            }
        }

    }
    @Resource
    private ServiceOrdersService serviceOrdersService;
    public List<ServiceOrders> findByService(Long staffId){
       return serviceOrdersService.findByStaffId(staffId);
    }
    @Resource
    private BusinessDateService businessDateService;
    @Resource
    private AttendanceService attendanceService;
}
