package com.mry.entity.dao.system;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.PostManagement;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/12/25.
 */
@SuppressWarnings("unchecked")
@Repository
public class PostDao extends AbstractDao<Object> {


    public PostManagement findById(Long id) {

        String queryString = "SELECT u FROM PostManagement u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<PostManagement> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<PostManagement> findList(Long id, String name, Integer page, Integer pageSize) {
        String str = "select u from PostManagement u  where u.isEnable = true";

        if(name != null && name != ""){
            str +=" and  u.postName like '%"+name+"%'";
        }
        if(id != null){
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id !=null){
            query.setParameter("id",id);
        }

        setPageInfo(query, page, pageSize);
        return query.getResultList();
    }

    public Long findListCount(Long id, String name) {
        String str = "select  count(u.id) from PostManagement u  where u.isEnable = true";

        if(name != null && name != ""){
            str +=" and  u.postName like '%"+name+"%'";
        }
        if(id != null){
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id !=null){
            query.setParameter("id",id);
        }
        return (Long) query.getSingleResult();
    }

    public int delete(Long id) {
        String querString = "UPDATE PostManagement a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }
}
