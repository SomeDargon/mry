package com.mry.entity.dao.store;

import com.mry.entity.Grouping;
import com.mry.entity.dao.AbstractDao;
import com.mry.json.store.GroupJson;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/10/27.
 */
@SuppressWarnings("unchecked")
@Repository
public class GroupDao extends AbstractDao<Object> {
    public List<GroupJson> findList(Long storeId, String name, Integer page, Integer pageSize) {

        String str = "select new com.mry.json.store.GroupJson(u.id,u.storeName,u.storeId,u.userName,u.userId,u.groupName,u.order) from Grouping u  where u.isEnable = true";

        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.groupName like '%"+name+"%'";
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
        String str = "select count(u.id) from Grouping u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.groupName like '%"+name+"%'";
        }
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        return (Long) query.getSingleResult();
    }

    public int delete(Long id) {
        String querString = "UPDATE Grouping a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public Grouping findById(Long id) {
        String queryString = "SELECT u FROM Grouping u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<Grouping> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }
}
