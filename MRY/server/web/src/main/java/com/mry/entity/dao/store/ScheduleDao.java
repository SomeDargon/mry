package com.mry.entity.dao.store;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.user.Schedule;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/11/21.
 */
@SuppressWarnings("unchecked")
@Repository
public class ScheduleDao extends AbstractDao<Object> {
    public Schedule findById(Long id) {
        String queryString = "SELECT u FROM Schedule u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<Schedule> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Schedule> findList(Long storeId, String scheduleDate,String scheduleStatus, Long id) {
        String str = "select u from Schedule u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:storeId";
        }
        if(id != null) {
            str += " and  u.staffId =:id";
        }
        if(scheduleStatus != null){
            str += " and  u.scheduleStatus =:scheduleStatus";
        }else {
            str += " and  u.scheduleStatus ='2'";
        }
        if(scheduleDate != null) {
            str += "  and DATE_FORMAT(u.scheduleDate,'%Y-%m-%d') = DATE_FORMAT('"+scheduleDate+"','%Y-%m-%d')";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("storeId", storeId);
        }
        if(id != null) {
            query.setParameter("id", id);
        }
        if(scheduleStatus != null) {
            query.setParameter("scheduleStatus", scheduleStatus);
        }

        return query.getResultList();
    }
}
