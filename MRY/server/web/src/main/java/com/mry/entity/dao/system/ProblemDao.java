package com.mry.entity.dao.system;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.customer.ProblemDescription;
import com.mry.entity.store.customer.Solution;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/11/28.
 */
@SuppressWarnings("unchecked")
@Repository
public class ProblemDao  extends AbstractDao<Object> {


    public List<ProblemDescription> findList(Long id) {
        String str = "select u from ProblemDescription u  where u.isEnable = true";
        if(id != null){
            str +=" and u.storeId=:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public int delete(Long id) {
        String querString = "UPDATE ProblemDescription a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public List<Solution> findSolutionList(Long id) {
        String str = "select u from Solution u  where u.isEnable = true";
        if(id != null){
            str +=" and u.storeId=:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public int deleteSolution(Long id) {
        String querString = "UPDATE Solution a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public ProblemDescription findById(Long problemId) {

        String querString = "SELECT d FROM ProblemDescription d WHERE d.isEnable = true AND d.id = :id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id",problemId);
        List<ProblemDescription> list = query.getResultList();
        return  list.size() > 0 ? list.get(0) : null;
    }
}
