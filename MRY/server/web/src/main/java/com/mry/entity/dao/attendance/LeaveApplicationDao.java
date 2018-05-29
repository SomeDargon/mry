package com.mry.entity.dao.attendance;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.card.CardManagement;
import com.mry.entity.user.LeaveApplication;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by somedragon on 2018/5/18.
 */
@SuppressWarnings("unchecked")
@Repository
public class LeaveApplicationDao extends AbstractDao<Object> {

    public LeaveApplication findById(Long id) {
        String queryString = "SELECT u FROM LeaveApplication u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<LeaveApplication> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

}
