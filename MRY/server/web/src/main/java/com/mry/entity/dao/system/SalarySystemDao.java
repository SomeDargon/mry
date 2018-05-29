package com.mry.entity.dao.system;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.salary.*;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2018/1/15.
 */
@SuppressWarnings("unchecked")
@Repository
public class SalarySystemDao extends AbstractDao<Object> {


    public MonthlyCashVolume findMonthlyCashVolumeById(Long id) {

        String queryString = "SELECT u FROM MonthlyCashVolume u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<MonthlyCashVolume> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteMonthlyCashVolume(Long id) {
        String querString = "UPDATE MonthlyCashVolume a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public StaffLevelBaseSalary findStaffLevelBaseSalaryById(Long id) {
        String queryString = "SELECT u FROM StaffLevelBaseSalary u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<StaffLevelBaseSalary> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteStaffLevelBaseSalary(Long id) {
        String querString = "UPDATE StaffLevelBaseSalary a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }
    public TotalMonthlyExercise findTotalMonthlyExerciseById(Long id) {
        String queryString = "SELECT u FROM TotalMonthlyExercise u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<TotalMonthlyExercise> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteTotalMonthlyExercise(Long id) {
        String querString = "UPDATE TotalMonthlyExercise a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }


    public TotalMonthlyPassengerFlow findTotalMonthlyPassengerFlowById(Long id) {
        String queryString = "SELECT u FROM TotalMonthlyPassengerFlow u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<TotalMonthlyPassengerFlow> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteTotalMonthlyPassengerFlow(Long id) {
        String querString = "UPDATE TotalMonthlyPassengerFlow a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public TotalMonthlyProject findTotalMonthlyProjectById(Long id) {
        String queryString = "SELECT u FROM TotalMonthlyProject u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<TotalMonthlyProject> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteTotalMonthlyProject(Long id) {
        String querString = "UPDATE TotalMonthlyProject a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public SalarySystem findByStoreId(Long id) {

        String queryString = "SELECT u FROM SalarySystem u WHERE u.storeId=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<SalarySystem> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;

    }

    public List<MonthlyCashVolume> findMonthlyCashVolume(Long id) {

        String str = "select u from MonthlyCashVolume u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<TotalMonthlyPassengerFlow> findTotalMonthlyPassengerFlow(Long id) {
        String str = "select u from TotalMonthlyPassengerFlow u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<TotalMonthlyExercise> findTotalMonthlyExercise(Long id) {
        String str = "select u from TotalMonthlyExercise u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<TotalMonthlyProject> findTotalMonthlyProject(Long id) {
        String str = "select u from TotalMonthlyProject u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<StaffLevelBaseSalary> findStaffLevelBaseSalary(Long id) {
        String str = "select u from StaffLevelBaseSalary u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public PracticalExercise findPracticalExerciseById(Long id) {
        String queryString = "SELECT u FROM PracticalExercise u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<PracticalExercise> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deletePracticalExercise(Long id) {

        String querString = "UPDATE PracticalExercise a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public PerformanceDrawing findPerformanceDrawingById(Long id) {
        String queryString = "SELECT u FROM PerformanceDrawing u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<PerformanceDrawing> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deletePerformanceDrawing(Long id) {
        String querString = "UPDATE PerformanceDrawing a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public AccumulativePassengerFlow findAccumulativePassengerFlowById(Long id) {
        String queryString = "SELECT u FROM AccumulativePassengerFlow u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<AccumulativePassengerFlow> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteAccumulativePassengerFlow(Long id) {
        String querString = "UPDATE AccumulativePassengerFlow a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public CashReward findCashRewardById(Long id) {
        String queryString = "SELECT u FROM CashReward u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<CashReward> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteCashReward(Long id) {
        String querString = "UPDATE CashReward a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }
    public PracticeReward findPracticeRewardById(Long id) {
        String queryString = "SELECT u FROM PracticeReward u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<PracticeReward> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deletePracticeReward(Long id) {

        String querString = "UPDATE PracticeReward a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public TeamBonus findTeamBonusById(Long id) {
        String queryString = "SELECT u FROM TeamBonus u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<TeamBonus> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteTeamBonus(Long id) {
        String querString = "UPDATE TeamBonus a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public ActivityBonus findActivityBonusById(Long id) {
        String queryString = "SELECT u FROM ActivityBonus u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<ActivityBonus> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteActivityBonus(Long id) {
        String querString = "UPDATE ActivityBonus a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public LeaveEarlyFines findLeaveEarlyFinesById(Long id) {
        String queryString = "SELECT u FROM LeaveEarlyFines u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<LeaveEarlyFines> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteLeaveEarlyFines(Long id) {
        String querString = "UPDATE LeaveEarlyFines a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public LeaveAfine findLeaveAfineById(Long id) {
        String queryString = "SELECT u FROM LeaveAfine u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<LeaveAfine> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteLeaveAfine(Long id) {
        String querString = "UPDATE LeaveAfine a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public CashPerformancePenalty findCashPerformancePpenaltyById(Long id) {
        String queryString = "SELECT u FROM CashPerformancePenalty u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<CashPerformancePenalty> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteCashPerformancePpenalty(Long id) {
        String querString = "UPDATE CashPerformancePenalty a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public PassengerFines findPassengerFinesById(Long id) {
        String queryString = "SELECT u FROM PassengerFines u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<PassengerFines> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deletePassengerFines(Long id) {
        String querString = "UPDATE PassengerFines a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public ConsumptionPenalty findConsumptionPenaltyById(Long id) {
        String queryString = "SELECT u FROM ConsumptionPenalty u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<ConsumptionPenalty> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteConsumptionPenalty(Long id) {
        String querString = "UPDATE ConsumptionPenalty a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public List<PracticalExercise> findPracticalExerciseByStoreId(Long id) {
        String str = "select u from PracticalExercise u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<PerformanceDrawing> findPerformanceDrawingByStoreId(Long id) {

        String str = "select u from PerformanceDrawing u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<TeamBonus> findTeamBonusByStoreId(Long id) {
        String str = "select u from TeamBonus u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<ActivityBonus> findActivityBonusByStoreId(Long id) {
        String str = "select u from ActivityBonus u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<LeaveEarlyFines> findLeaveEarlyFinesByStoreId(Long id) {
        String str = "select u from LeaveEarlyFines u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<LeaveAfine> findLeaveAfineByStoreId(Long id) {
        String str = "select u from LeaveAfine u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<CashPerformancePenalty> findCashPerformancePpenaltyByStoreId(Long id) {
        String str = "select u from CashPerformancePenalty u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<PassengerFines> findPassengerFinesByStoreId(Long id) {
        String str = "select u from PassengerFines u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<ConsumptionPenalty> findConsumptionPenaltyByStoreId(Long id) {
        String str = "select u from ConsumptionPenalty u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<AccumulativePassengerFlow> findAccumulativePassengerFlowByStoreId(Long id) {
        String str = "select u from AccumulativePassengerFlow u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<CashReward> findCashRewardByStoreId(Long id) {
        String str = "select u from CashReward u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public List<PracticeReward> findPracticeRewardByStoreId(Long id) {
        String str = "select u from PracticeReward u  where u.isEnable = true";

        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public SalarySystem findById(Long id) {
        String queryString = "SELECT u FROM SalarySystem u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<SalarySystem> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }


}
