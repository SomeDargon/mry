package com.mry.entity.dao.system;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.card.ActivityCardManagement;
import com.mry.entity.store.card.ExtensionCardManagement;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2018/1/11.
 */
@SuppressWarnings("unchecked")
@Repository
public class ActivityDao extends AbstractDao<Object>  {


    public int deleteProject(Long id) {
        String querString = "delete FROM  ActivityProject u where   u.activity.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;

    }

    public int deleteNewCustomerParticipation(Long id) {

        String querString = "delete FROM  NewCustomerParticipation u where   u.activity.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public int deleteApecialSecondKill(Long id) {
        String querString = "delete FROM  SpecialSecondKill u where   u.activity.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public int deleteToStoreProject(Long id) {

        String querString = "delete FROM  ToStoreProject u where   u.activity.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public int deleteCourseOfActivityCard(Long id) {

        String querString = "delete FROM  CourseOfActivityCard u where   u.activity.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public int deleteProductSecondKill(Long id) {

        String querString = "delete FROM  ProductSecondKill u where   u.activity.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public List<ActivityCardManagement> findactivity(Long id, String name) {
        String str = "select u from ActivityCardManagement u  where u.isEnable = true";
        if(name != null && name !="") {
            str +=" and  u.activityName like '%"+name+"%'";
        }

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

    public int delete(Long id) {

        String querString = "UPDATE ActivityCardManagement a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public ActivityCardManagement findById(Long id) {
        String queryString = "SELECT u FROM ActivityCardManagement u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<ActivityCardManagement> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }


}
