package com.mry.entity.dao.store;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.user.Staff;
import com.mry.entity.user.StaffManyCustomer;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.persistence.Query;

/**
 * Created by somedragon on 2018/4/17.
 */
@SuppressWarnings("unchecked")
@Repository
public class StaffManyCustomerDao  extends AbstractDao<Object> {

    public StaffManyCustomer findCustomer(Long userId, Long storeId, Integer type) {
        String queryString = "SELECT u FROM StaffManyCustomer u WHERE 1=1 ";
        if(storeId != null) {
            queryString +=" and  u.storeId =:storeId";
        }
        if(userId != null) {
            queryString +=" and  u.customerId =:customerId";
        }
        if(userId != null) {
            queryString +=" and  u.type =:type";
        }
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("storeId", storeId);
        query.setParameter("customerId", userId);
        query.setParameter("type", type);
        List<StaffManyCustomer> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }
}
