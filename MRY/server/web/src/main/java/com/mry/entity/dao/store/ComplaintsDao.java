package com.mry.entity.dao.store;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.ComplaintsManagement;
import com.mry.entity.store.project.ProjectManagement;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2017/11/3.
 */
@SuppressWarnings("unchecked")
@Repository
public class ComplaintsDao extends AbstractDao<Object> {
    public ComplaintsManagement findById(Long id)  {

        String queryString = "SELECT u FROM ComplaintsManagement u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }

        List<ComplaintsManagement> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<ComplaintsManagement> findList(Long storeId, String name, Integer page, Integer pageSize) {
        String str = "select u from ComplaintsManagement u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.btsrName like '%"+name+"%'";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        setPageInfo(query, page, pageSize);
        return query.getResultList();
    }

    public Long findListCount(Long storeId, String name) {
        String str = "select count(u.id) from ComplaintsManagement u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.projectName like '%"+name+"%'";
        }
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        return (Long) query.getSingleResult();
    }

    public int delete(Long id) {
        String querString = "UPDATE ComplaintsManagement a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public Long findMax(Long id) {

        String str = "select count(u.id) from ComplaintsManagement u   ";
        if(id != null) {
            str +=" where  u.storeId =:id";
        }
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return (Long) query.getSingleResult();
    }
}
