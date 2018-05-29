package com.mry.entity.dao.store;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.inventory.Warehousing;
import com.mry.entity.store.inventory.WarehousingOut;
import com.mry.json.store.WarehousingPdJson;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/11/20.
 */
@SuppressWarnings("unchecked")
@Repository
public class WarehousingDao extends AbstractDao<Object> {


    public Warehousing findById(Long id) {
        String queryString = "SELECT u FROM Warehousing u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<Warehousing> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Warehousing> findWarehousingList(Long storeId, String name, Integer page, Integer pageSize) {

        String str = "select u from Warehousing u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.name =:name";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        if(name != null && name != ""){
            query.setParameter("name", name);
        }
        setPageInfo(query, page, pageSize);
        return query.getResultList();
    }

    public Long findWarehousingCount(Long storeId, String name) {
        String str = "select count(u.id) from Warehousing u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.name =:name";
        }
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        if(name != null && name != ""){
            query.setParameter("name", name);
        }
        return (Long) query.getSingleResult();
    }

    public int delete(Long id) {
        String querString = "UPDATE Warehousing a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public List<WarehousingPdJson> findList(Long storeId, String name, Integer page, Integer pageSize) {

        String str = "select new com.mry.json.store.WarehousingPdJson(u.storeId,u.name,sum(u.actualQuantity)) from Warehousing u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
//        if(name != null && name != ""){
//            str +=" and  u.name =:name";
//        }
        str +=" GROUP  BY u.name ";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
//        if(name != null && name != ""){
//            query.setParameter("name", name);
//        }
        setPageInfo(query, page, pageSize);
        return query.getResultList();
    }

    public Long findCount(Long storeId, String name) {
        String str ="select count(DISTINCT w.name) from Warehousing w  where w.isEnable = true  and  w.storeId ="+storeId;
        Query query = getEntityManager().createQuery(str);
        return (Long) query.getSingleResult();
    }

    public List<WarehousingOut> findOutList(Long storeId, String name,String type, Integer page, Integer pageSize) {
        String str = "select u from WarehousingOut u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.name =:name";
        }
        if(null != type){
            str +=" and  u.storageType =:storageType";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        if(name != null && name != ""){
            query.setParameter("name", name);
        }
        if(type != null && type != ""){
            query.setParameter("storageType", type);
        }
        setPageInfo(query, page, pageSize);
        return query.getResultList();
    }

    public Long findOurCount(Long storeId, String name,String type) {
        String str = "select count(u.id) from WarehousingOut u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.name =:name";
        }
        if(null != type){
            str +=" and  u.storageType =:storageType";
        }
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        if(name != null && name != ""){
            query.setParameter("name", name);
        }
        if(type != null && type != ""){
            query.setParameter("storageType", type);
        }
        return (Long) query.getSingleResult();
    }

    public List<WarehousingPdJson> findSumList(Long storeId, String name) {

        String str = "select new com.mry.json.store.WarehousingPdJson(u.storeId,u.name,sum(u.actualQuantity)) from Warehousing u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.name =:name";
        }
        str +=" GROUP  BY u.name ";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        if(name != null && name != ""){
            query.setParameter("name", name);
        }
        return query.getResultList();
    }

    public List<Warehousing> findSumWarehousingList(Long storeId, String name) {

        String str = "select u from Warehousing u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.name =:name";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        if(name != null && name != ""){
            query.setParameter("name", name);
        }
        return query.getResultList();
    }

    public List<WarehousingPdJson> findAllList(Long storeId) {
        String str = "select new com.mry.json.store.WarehousingPdJson(u.storeId,u.name,sum(u.actualQuantity)) from Warehousing u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
//        if(name != null && name != ""){
//            str +=" and  u.name =:name";
//        }
        str +=" GROUP  BY u.name ";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
//        if(name != null && name != ""){
//            query.setParameter("name", name);
//        }
        return query.getResultList();
    }
}
