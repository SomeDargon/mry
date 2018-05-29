package com.mry.entity.dao.store;

import com.mry.entity.dao.AbstractDao;
import com.mry.json.store.RoleJson;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/10/27.
 */
@SuppressWarnings("unchecked")
@Repository
public class RoleDao extends AbstractDao<Object> {
    public List<RoleJson> findList(String name, Integer page, Integer pageSize) {
        String str = "select new com.mry.json.store.RoleJson(u.id,u.roleName,u.sort) from Role u  where u.isEnable = true";
//        if(storeId != null) {
//            str +=" and  u.storeId =:id";
//        }
        if(name != null && name != ""){
            str +=" and  u.roleName like '%"+name+"%'";
        }
         str +=" order by u.sort desc";
        Query query = getEntityManager().createQuery(str);
//        if(storeId != null) {
//            query.setParameter("id", storeId);
//        }
        setPageInfo(query, page, pageSize);
        return query.getResultList();
    }

    public Long findListCount(String name) {
        String str = "select count(u.id) from Role u  where u.isEnable = true";
//        if(storeId != null) {
//            str +=" and  u.storeId =:id";
//        }
        if(name != null && name != ""){
            str +=" and  u.roleName like '%"+name+"%'";
        }
        Query query = getEntityManager().createQuery(str);
//        if(storeId != null) {
//            query.setParameter("id", storeId);
//        }
        return (Long) query.getSingleResult();
    }

    public int delete(Long id) {
        String querString = "UPDATE Role a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }
}
