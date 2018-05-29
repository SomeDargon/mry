package com.mry.entity.dao.store;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.RoomManagement;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/11/1.
 */
@SuppressWarnings("unchecked")
@Repository
public class RoomDao extends AbstractDao<Object> {
    public RoomManagement findById(Long id) {
        String queryString = "SELECT u FROM RoomManagement u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<RoomManagement> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<RoomManagement> findList(Long storeId, String name, Integer page, Integer pageSize) {

        String str = "select u from RoomManagement u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.roomName like '%"+name+"%'";
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
        String str = "select count(u.id) from RoomManagement u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.roomName like '%"+name+"%'";
        }
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        return (Long) query.getSingleResult();
    }

    public int delete(Long id) {
        String querString = "UPDATE RoomManagement a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public List<RoomManagement> findAllRoom(Long storeId) {

        String str = "select u from RoomManagement u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }

        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        return query.getResultList();
    }
}
