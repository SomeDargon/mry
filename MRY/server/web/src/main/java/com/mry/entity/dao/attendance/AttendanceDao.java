package com.mry.entity.dao.attendance;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.dao.store.BaseDao;
import com.mry.entity.store.ComplaintsManagement;
import com.mry.entity.store.attendance.Attendance;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by somedragon on 2018/4/26.
 */
@SuppressWarnings("unchecked")
@Repository
public class AttendanceDao extends AbstractDao<Object> {

    public Attendance findByStoreIdAndUserIdAndDate(Long storeId, Long userId, Date date)  {

        String queryString = "SELECT u FROM Attendance u WHERE 1=1 ";
        if(storeId !=null){
            queryString +=" and u.storeId =:storeId";
        }
        if(userId !=null){
            queryString +=" and u.userId =:userId";
        }
        if(date !=null){
            queryString +=" and u.currentDate =:currentDate";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(storeId !=null){
            query.setParameter("storeId",storeId);
        }
        if(storeId !=null){
            query.setParameter("userId",userId);
        }
        if(storeId !=null){
            query.setParameter("currentDate",date);
        }

        List<Attendance> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Attendance> findByUserIdAndDate(Long userId, Date sdate, Date edate)  {

        String queryString = "SELECT u FROM Attendance u WHERE 1=1 and userId=:userId and currentDate> :sdate and currentDate < :edate";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("userId", userId);
        query.setParameter("sdate", sdate);
        query.setParameter("edate", edate);
        return query.getResultList();
    }
}
