package com.mry.entity.dao.store;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.ComplaintsManagement;
import com.mry.entity.store.card.MembersEnjoy;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by somedragon on 2018/4/13.
 */
@SuppressWarnings("unchecked")
@Repository
public class MembersEnjoyDao extends AbstractDao<Object> {

    public List<MembersEnjoy> findByCardId(Long id)  {

        String queryString = "SELECT u FROM MembersEnjoy u WHERE 1=1 ";
        if(id !=null){
            queryString +=" and u.card.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }

        return query.getResultList();
    }
}
