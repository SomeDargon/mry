package com.mry.entity.dao.store;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.util.DatetimeUtil;
import org.apache.poi.ss.usermodel.DateUtil;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2017/11/14.
 * 服务单
 */
@SuppressWarnings("unchecked")
@Repository
public class ServiceOrdersDao extends AbstractDao<Object> {


    public Long findCount(Long storeId) {
        String str = "select count(u.id) from ServiceOrders u   ";

        if(storeId != null ){
            str +=" where   u.storeId =:storeId";
        }
        Query query = getEntityManager().createQuery(str);
        query.setParameter("storeId",storeId);
        return (Long) query.getSingleResult();
    }

    public ServiceOrders findById(Long id) {
        String queryString = "SELECT u FROM ServiceOrders u  ";//WHERE u.isEnable=true
        if(id !=null){
            queryString +=" WHERE u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<ServiceOrders> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;

    }

    public List<ServiceOrders> findByStaffId(Long id) {
        String queryString = "SELECT u FROM ServiceOrders u  ";//WHERE u.isEnable=true
        if(id !=null){
            queryString +=" WHERE u.operatorId =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("operatorId",id);
        }
        return  query.getResultList();

    }

    public int deleteproject(Long id) {
        String querString = "delete FROM  ServiceProject u where   u.order.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public int deleteproduct(Long id) {
        String querString = "delete FROM  ServiceProduct u where   u.order.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public List<ServiceOrders> findServiceOrder(Long storeId,String orderType, String name, Integer page, Integer pageSize) {

        String str = "select u from ServiceOrders u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.serviceOrderNumber =:serviceOder";
        }
        if(orderType != null && orderType != ""){
            str +=" and  u.orderType =:orderType";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        if(name != null && name != ""){
            query.setParameter("serviceOder", name);
        }
        if(orderType != null && orderType != ""){
            query.setParameter("orderType", orderType);
        }
        setPageInfo(query, page, pageSize);
        return query.getResultList();
    }

    public Long findListCount(Long storeId, String orderType,String name) {

        String str = "select count(u.id) from ServiceOrders u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name != ""){
            str +=" and  u.serviceOrderNumber =:serviceOder";
        }
        if(orderType != null && orderType != ""){
            str +=" and  u.orderType =:orderType";
        }
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        if(name != null && name != ""){
            query.setParameter("serviceOder", name);
        }
        if(orderType != null && orderType != ""){
            query.setParameter("orderType", orderType);
        }
        return (Long) query.getSingleResult();
    }

    public List<ServiceOrders> findByCustomerId(Long id) {
        String str = "select u from ServiceOrders u  where u.isEnable = true";

        if(id != null ){
            str +=" and  u.customerId =:id";
        }
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }

        return query.getResultList();
    }

    //查询上一次服务者
    public ServiceOrders findLastService( Long id,Long storeId) {
        String str = "select u from ServiceOrders u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:storeId";
        }
        if(id != null) {
            str +=" and  u.customerId =:id";
        }
        str +=" order by u.createTime desc";
        Query query = getEntityManager().createQuery(str);
        query.setParameter("storeId", storeId);
        query.setParameter("id", id);
        setPageInfo(query, 0, 1);
        List<ServiceOrders> s = query.getResultList();
        return s.size()>0?s.get(0):null;
    }


    public Long findMaxTime(Long storeId) {
        String sql =
                "select operator_id from (select count(*) count, s.operator_id from service_orders s " +
                        "where 1=1  and s.store_id="+storeId+" group by s.operator_id ) t order by t.count desc LIMIT 0,1";
        Query sqlQuery = getEntityManager().createNativeQuery(sql);
        List<BigInteger> s = sqlQuery.getResultList();
        return s.size()>0?Long.parseLong(s.get(0).toString()):0;

    }


    public List<ServiceOrders> findByStoreIdAndDate(Long storeId, Date begin, Date end) {
        String str = "select u from ServiceOrders u  where u.isEnable = true and u.servicStatus = 2 " +
                "AND createTime >= :begin AND u.createTime < :end ";

        if(storeId != null ){
            str +=" and  u.storeId =:id";
        }
        Query query = getEntityManager().createQuery(str);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        query.setParameter("begin", begin);
        query.setParameter("end", end);

        return query.getResultList();
    }
}
