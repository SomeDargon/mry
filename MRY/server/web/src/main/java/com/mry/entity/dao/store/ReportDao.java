package com.mry.entity.dao.store;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.system.*;
import com.mry.json.store.BeauticianJson;
import com.mry.json.store.DailyListJson;
import com.mry.json.store.DaySumJson;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/11/30.
 */
@SuppressWarnings("unchecked")
@Repository
public class ReportDao extends AbstractDao<Object> {

    public List<DailyListJson> findDayList(Long storeId, String reportTime) {

        String queryStr = "select new com.mry.json.store.DailyListJson(" +
                "u.storeName,u.customer,u.serviceId,u.serviceOrderNumber,u.billType,u.paymentMethod,u.money,u.billTime) " +
                " from Bill u  where  date_format(u.billTime,'%Y-%m-%d') = str_to_date('"+reportTime+"','%Y-%m-%d')";
        if (null != storeId) {
            queryStr += " and u.storeId=:storeId";
        }
        Query query = getEntityManager().createQuery(queryStr);
        if (null != storeId) {
            query.setParameter("storeId", storeId);
        }
        List<DailyListJson> list=query.getResultList();
        return query.getResultList();
    }

    public DaySumJson findDaySum(Long storeId, String reportTime) {

        String queryStr = "select new com.mry.json.store.DaySumJson(" +
                "count(u.id),sum(u.money)) " +
                " from Bill u  where  DATE_FORMAT(u.billTime,'%Y-%m-%d') = str_to_date('"+reportTime+"','%Y-%m-%d') ";
        if (null != storeId) {
            queryStr += " and u.storeId=:storeId";
        }
        Query query = getEntityManager().createQuery(queryStr);
        if (null != storeId) {
            query.setParameter("storeId", storeId);
        }
        List<DaySumJson> list = query.getResultList();
        return list.size()>0?list.get(0):null;
    }

    public List<DaySumJson> findMouthList(Long storeId, String date) {
        String queryStr = "select new com.mry.json.store.DaySumJson(" +
                "count(u.id),sum(u.money)) " +
                " from Bill u  where  DATE_FORMAT(u.billTime,'%Y-%m') =  date_format(str_to_date('"+date+"', '%Y-%m-%d'),'%Y-%m') ";
        if (null != storeId) {
            queryStr += " and u.storeId=:storeId";
        }
        queryStr += " GROUP BY DATE_FORMAT(u.billTime,'%Y-%m-%d') order by u.billTime";
        Query query = getEntityManager().createQuery(queryStr);
        if (null != storeId) {
            query.setParameter("storeId", storeId);
        }
        return query.getResultList();
    }

    public DaySumJson findMouthSum(Long storeId, String date) {
        String queryStr = "select new com.mry.json.store.DaySumJson(" +
                "count(u.id),sum(u.money)) " +
                " from Bill u  where  DATE_FORMAT(u.billTime,'%Y-%m') = date_format('"+date+"','%Y%m')  ";
        if (null != storeId) {
            queryStr += " and u.storeId=:storeId";
        }

        Query query = getEntityManager().createQuery(queryStr);
        if (null != storeId) {
            query.setParameter("storeId", storeId);
        }
        List<DaySumJson> list = query.getResultList();
        return list.size()>0?list.get(0):null;
    }

    public List<BeauticianJson> findBeauticianDaySum(Long storeId, Long id, String date) {
        String queryStr = "select new com.mry.json.store.BeauticianJson(" +
                "count(u.id),sum(u.money)) " +
                " from Bill u left join ServiceOrders s on u.serviceId = s.id  where  DATE_FORMAT(u.billTime,'%Y-%m') = date_format(str_to_date('"+date+"', '%Y-%m-%d'),'%Y-%m') ";
        if (null != storeId) {
            queryStr += " and u.storeId=:storeId";
        }
        if (null != id) {
            queryStr += " and u.storeId=:id";
        }
        queryStr += " GROUP BY DATE_FORMAT(b.billTime,'%Y-%m-%d') order by u.billTime";
        Query query = getEntityManager().createQuery(queryStr);
        if (null != storeId) {
            query.setParameter("storeId", storeId);
        }
        if (null != storeId) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public DailyStoreDesign findDailyStoreDesign(Long id) {

        String queryStr = "select u from DailyStoreDesign u  where u.isEnable =true  ";
        if (null != id) {
            queryStr += " and u.storeId=:storeId";
        }
        Query query = getEntityManager().createQuery(queryStr);
        if (null != id) {
            query.setParameter("storeId", id);
        }
        List<DailyStoreDesign> list = query.getResultList();
        return list.size()>0?list.get(0):null;
    }

    public ShopMonthlyReport findShopMonthlyReport(Long id) {
        String queryStr = "select u from ShopMonthlyReport u  where u.isEnable =true  ";
        if (null != id) {
            queryStr += " and u.storeId=:storeId";
        }
        Query query = getEntityManager().createQuery(queryStr);
        if (null != id) {
            query.setParameter("storeId", id);
        }
        List<ShopMonthlyReport> list = query.getResultList();
        return list.size()>0?list.get(0):null;
    }

    public ConsultantMonthlyReport findConsultantMonthlyReport(Long id) {
        String queryStr = "select u from ConsultantMonthlyReport u  where u.isEnable =true  ";
        if (null != id) {
            queryStr += " and u.storeId=:storeId";
        }
        Query query = getEntityManager().createQuery(queryStr);
        if (null != id) {
            query.setParameter("storeId", id);
        }
        List<ConsultantMonthlyReport> list = query.getResultList();
        return list.size()>0?list.get(0):null;
    }

    public BeauticianMonthlyReport findBeauticianMonthlyReport(Long id) {

        String queryStr = "select u from BeauticianMonthlyReport u  where u.isEnable =true  ";
        if (null != id) {
            queryStr += " and u.storeId=:storeId";
        }
        Query query = getEntityManager().createQuery(queryStr);
        if (null != id) {
            query.setParameter("storeId", id);
        }
        List<BeauticianMonthlyReport> list = query.getResultList();
        return list.size()>0?list.get(0):null;
    }

    public HairTechnicianMonthlyReport findHairTechnicianMonthlyReport(Long id) {

        String queryStr = "select u from HairTechnicianMonthlyReport u  where u.isEnable =true  ";
        if (null != id) {
            queryStr += " and u.storeId=:storeId";
        }
        Query query = getEntityManager().createQuery(queryStr);
        if (null != id) {
            query.setParameter("storeId", id);
        }
        List<HairTechnicianMonthlyReport> list = query.getResultList();
        return list.size()>0?list.get(0):null;
    }

    public ManagerOfTheMonthlyReport findManagerOfTheMonthlyReport(Long id) {

        String queryStr = "select u from ManagerOfTheMonthlyReport u  where u.isEnable =true  ";
        if (null != id) {
            queryStr += " and u.storeId=:storeId";
        }
        Query query = getEntityManager().createQuery(queryStr);
        if (null != id) {
            query.setParameter("storeId", id);
        }
        List<ManagerOfTheMonthlyReport> list = query.getResultList();
        return list.size()>0?list.get(0):null;
    }

    public ShopDailyDetails findShopDailyDetails(Long id) {

        String queryStr = "select u from ShopDailyDetails u  where u.isEnable =true  ";
        if (null != id) {
            queryStr += " and u.storeId=:storeId";
        }
        Query query = getEntityManager().createQuery(queryStr);
        if (null != id) {
            query.setParameter("storeId", id);
        }
        List<ShopDailyDetails> list = query.getResultList();
        return list.size()>0?list.get(0):null;
    }
}
