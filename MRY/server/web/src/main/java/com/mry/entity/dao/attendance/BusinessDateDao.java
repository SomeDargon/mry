package com.mry.entity.dao.attendance;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.attendance.BusinessDate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by somedragon on 2018/5/18.
 */
@SuppressWarnings("unchecked")
@Repository
public class BusinessDateDao extends AbstractDao<Object> {
    public BusinessDate findById(Date date) {
        String querString = "SELECT d FROM BusinessDate d WHERE 1=1 and d.date = :date";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("date",date);
        List<BusinessDate> list = query.getResultList();
        return  list.size() > 0 ? list.get(0) : null;
    }

    public List<BusinessDate> getStartAndEndTime(Date sDate, Date eDate) {
        String querString = "SELECT d FROM BusinessDate d WHERE 1=1 and d.date > :sDate and d.date < :eDate";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("sDate",sDate);
        query.setParameter("eDate",eDate);
        return query.getResultList();
    }
}
