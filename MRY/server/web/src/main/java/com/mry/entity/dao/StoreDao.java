package com.mry.entity.dao;

import com.mry.entity.StoreManagement;
import com.mry.entity.common.City;
import com.mry.entity.common.Province;
import com.mry.json.ProvinceForJson;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/10/30.
 */
@SuppressWarnings("unchecked")
@Repository
public class StoreDao extends AbstractDao<Object>{


    public StoreManagement findById(Long storeId) {
        String querString = "SELECT d FROM StoreManagement d WHERE d.isEnable = true AND d.id = :id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id",storeId);
        List<StoreManagement> list = query.getResultList();
        return  list.size() > 0 ? list.get(0) : null;
    }

    public Long findMax() {
        String str = "select count(u.id) from StoreManagement u";

        Query query = getEntityManager().createQuery(str);

        return (Long) query.getSingleResult();
    }

    public List<StoreManagement> findList(Long id,String name, Integer page, Integer pageSize) {
        String str = "select u from StoreManagement u  where u.isEnable = true and u.auditStatus='2'";

        if(name != null && name != ""){
            str +=" and  u.storeName like '%"+name+"%'";
        }

        if(id != null){
            str +=" and  u.id =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        setPageInfo(query, page, pageSize);
        if(id != null){
            query.setParameter("id",id);
        }
        return query.getResultList();
    }

    public Long findListCount(Long id,String name) {

        String str = "select count(u.id) from StoreManagement u  where u.isEnable = true";

        if(name != null && name != ""){
            str +=" and  u.storeName like '%"+name+"%'";
        }
        if(id != null){
            str +=" and  u.id =:id";
        }
        Query query = getEntityManager().createQuery(str);
        if(id != null){
            query.setParameter("id",id);
        }
        return (Long) query.getSingleResult();
}

    public int delete(Long id) {
        String querString = "UPDATE StoreManagement a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public boolean checkStoreName(String storeName) {
        String queryString = "SELECT u.id FROM StoreManagement u WHERE u.storeName =:name ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("name", storeName);
        return query.getResultList().size() > 0;
    }

    public List<City> findAllCities() {
        String queryString = "SELECT c FROM City c WHERE c.isActive=true ";

        Query query = getEntityManager().createQuery(queryString);

        List<City> list = query.getResultList();
        return list;
    }

    public List<Province> getAllProvinces() {
        String queryString = "SELECT p FROM Province p WHERE p.isActive=true ";
        Query query = getEntityManager().createQuery(queryString);
        return query.getResultList();
    }

    public List<City> findCitiesByProvinceId(Long provinceId) {
        String queryString = "SELECT p FROM City p WHERE p.province.id=:pid AND p.isActive=true ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("pid", provinceId);
        return query.getResultList();
    }

    public City findCittByid(Long cityId) {

        String querString = "SELECT d FROM City d WHERE d.isActive = true AND d.id = :id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id",cityId);
        List<City> list = query.getResultList();
        return  list.size() > 0 ? list.get(0) : null;
    }

    public ProvinceForJson findProvinceById(Long provinceId) {

        String queryString = "SELECT new com.mry.json.ProvinceForJson(p.id,p.name) FROM Province p WHERE p.isActive=true AND p.id = :id";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id",provinceId);
        List<ProvinceForJson> list =  query.getResultList();
        return  list.size() > 0 ? list.get(0) : null;
    }

    public List<StoreManagement> findStoreRegister(Long id, String name, Integer page, Integer pageSize) {

        String str = "select u from StoreManagement u  where u.isEnable = true and u.auditStatus='1' or u.auditStatus='3'";

        if(name != null && name != ""){
            str +=" and  u.storeName like '%"+name+"%'";
        }

        if(id != null){
            str +=" and  u.id =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        setPageInfo(query, page, pageSize);
        if(id != null){
            query.setParameter("id",id);
        }
        return query.getResultList();
    }

    public Long findRegisterCount(Long id, String name) {

        String str = "select count(u.id) from StoreManagement u  where u.isEnable = true and u.auditStatus='1'";

        if(name != null && name != ""){
            str +=" and  u.storeName like '%"+name+"%'";
        }
        if(id != null){
            str +=" and  u.id =:id";
        }
        Query query = getEntityManager().createQuery(str);
        if(id != null){
            query.setParameter("id",id);
        }
        return (Long) query.getSingleResult();
    }

    public StoreManagement findByNumber(String phoneNumber) {


        String querString = "SELECT d FROM StoreManagement d WHERE d.isEnable = true  AND d.phoneNumber = :phoneNumber";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("phoneNumber",phoneNumber);
        List<StoreManagement> list = query.getResultList();
        return  list.size() > 0 ? list.get(0) : null;
    }

    public boolean checkStorePhone(String phoneNumber) {
        String queryString = "SELECT u.id FROM StoreManagement u WHERE u.phoneNumber =:phoneNumber ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("phoneNumber", phoneNumber);
        return query.getResultList().size() > 0;
    }
}
