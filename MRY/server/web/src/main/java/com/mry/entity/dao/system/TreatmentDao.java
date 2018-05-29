package com.mry.entity.dao.system;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.card.TreatmentCardManagement;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2018/1/7.
 */
@SuppressWarnings("unchecked")
@Repository
public class TreatmentDao extends AbstractDao<Object>{


    public TreatmentCardManagement findById(Long id) {

        String querString = "SELECT d FROM TreatmentCardManagement d WHERE d.isEnable = true AND d.id = :id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id",id);
        List<TreatmentCardManagement> list = query.getResultList();
        return  list.size() > 0 ? list.get(0) : null;
    }

    public int delete(Long id) {
        String querString = "UPDATE TreatmentCardManagement a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;

    }

    public List<TreatmentCardManagement> findTreatment(Long storeId,String name) {
        String str = "select u from TreatmentCardManagement u  where u.isEnable = true";

        if(storeId != null) {
            str +=" and  u.storeId =:storeId";
        }
        if(name != null && name !="") {
            str +=" and  u.treatmentName like '%"+name+"%'";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        query.setParameter("storeId", storeId);
        return query.getResultList();
    }



    public int deleteProjectById(Long id) {
        String querString = "delete FROM  ExtensionCardProject u where   u.treatment.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }
}
