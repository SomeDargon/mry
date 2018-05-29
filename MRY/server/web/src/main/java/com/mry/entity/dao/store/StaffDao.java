package com.mry.entity.dao.store;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.user.Staff;
import com.mry.entity.user.StaffSession;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/10/30.
 */
@SuppressWarnings("unchecked")
@Repository
public class StaffDao extends AbstractDao<Object> {


    public Staff findAccount(String account) {

        String queryString = "SELECT u FROM Staff u WHERE u.account=:username ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("username", account);

        List<Staff> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Staff> findList(Long storeId, String name, Integer page, Integer pageSize) {
        String str = "select u from Staff u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.realName like '%"+name+"%'";
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
        String str = "select count(u.id) from Staff u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.realName like '%"+name+"%'";
        }
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        return (Long) query.getSingleResult();
    }

    public Long findCount(Long storeId) {
        String str = "select count(u.id) from Staff u";
        if(storeId != null) {
            str +=" where  u.storeId =:id";
        }
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        return (Long) query.getSingleResult();
    }

    public Staff findUser(Long id) {
        String queryString = "SELECT u FROM Staff u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.storeId =:id";
        }
        queryString +=" and u.roleId =1";
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<Staff> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public Staff findById(Long id) {
        String queryString = "SELECT u FROM Staff u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<Staff> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Staff> findQuitList(Long storeId, String name, Integer page, Integer pageSize) {
        String str = "select u from Staff u  where u.isEnable = false";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.realName like '%"+name+"%'";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        setPageInfo(query, page, pageSize);
        return query.getResultList();
    }

    public Long findQuitCount(Long storeId, String name) {
        String str = "select count(u.id) from Staff u  where u.isEnable = false";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.realName like '%"+name+"%'";
        }
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        return (Long) query.getSingleResult();
    }

    public List<Staff> findByStores(Long storeId,Long roleId) {
        String str = "select u from Staff u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(roleId != null) {
            str += " and  u.roleId =:roleId";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        if(roleId != null) {
            query.setParameter("roleId", roleId);
        }

        return query.getResultList();
    }

    public int deleteStoreUser(Long id, Long roleId) {
        String querString = "delete FROM Staff  a  WHERE a.storeId =:id and a.roleId=:roleId";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        query.setParameter("roleId", roleId);
        int res=query.executeUpdate();
        return res;
    }

    public List<Staff> findAllUser(Long storeId) {

        String str = "select u from Staff u  where u.isEnable = true";
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

    public Staff findStoreUser(Long id, Long roleId) {
        String str = "select u from Staff u  where u.isEnable = true";
        if(id != null) {
            str +=" and  u.storeId =:id";
        }
        if(roleId != null) {
            str +=" and  u.roleId =:roleId";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        if(roleId != null) {
            query.setParameter("roleId", roleId);
        }
        List<Staff> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public Staff findStoreByPhone(String phoneNumber) {

        String queryString = "SELECT u FROM Staff u WHERE u.isEnable=true ";
        queryString +=" and u.phoneNumber =:phoneNumber";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("phoneNumber",phoneNumber);

        List<Staff> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public StaffSession findAdminUserSessionByAuthToken(String authToken) {
        String queryString = "SELECT u FROM StaffSession u" + " WHERE u.authToken=:authToken "
                + " AND u.isExpired=:expired ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("authToken", authToken);
        query.setParameter("expired", false);

        List<StaffSession> list = query.getResultList();
        return list.size() == 0 ? null : list.get(0);
    }

    public List<Staff> findByStallNotIds(String ids, Long storeId) {

        String str = "select u from Staff u  where u.isEnable = true and u.id not in ("+ids+")";
        if(storeId != null) {
            str +=" and  u.storeId ="+storeId;
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);

        return query.getResultList();
    }
}
