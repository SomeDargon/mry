package com.mry.entity.dao.store;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.card.Bill;
import com.mry.entity.store.customer.*;
import com.mry.entity.user.Customer;
import com.mry.json.store.ProblemDescriptionJson;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/10/31.
 */
@SuppressWarnings("unchecked")
@Repository
public class CustomerDao extends AbstractDao<Object> {
    public Customer findById(Long id) {

        String queryString = "SELECT u FROM Customer u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<Customer> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Customer> findList(Long storeId, String name, Integer page, Integer pageSize) {
        String str = "select u from Customer u  where u.isEnable = true";
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
        String str = "select count(u.id) from Customer u  where u.isEnable = true";
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

    public int delete(Long id) {
        String querString = "UPDATE Customer a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public List<OwningCard> findOwningCard(Long id, Integer page, Integer pageSize) {
        String str = "select u from OwningCard u  where u.isEnable = true";

        if(id != null ){
            str +=" and  u.customerId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        setPageInfo(query, page, pageSize);
        return query.getResultList();

    }

    public Long findOwningCardCount(Long id) {

        String str = "select count(u.id) from OwningCard u  where u.isEnable = true";
        if(id != null ){
            str +=" and  u.customerId =:id";
        }
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return (Long) query.getSingleResult();
    }

    public List<Customer> findAllCustomer(Long storeId) {
        String str = "select u from Customer u  where u.isEnable = true";
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

    public List<OwningCard> findOwningCardByCustomer(Long customerId) {

        String str = "select u from OwningCard u  where u.isEnable = true";

        if(customerId != null ){
            str +=" and  u.customerId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(customerId != null) {
            query.setParameter("id", customerId);
        }
        return query.getResultList();
    }

    public List<MyProject> findMyProject(Long customerId) {

        String str = "select u from MyProject u   ";

        if(customerId != null ){
            str +=" where  u.customerId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(customerId != null) {
            query.setParameter("id", customerId);
        }
        return query.getResultList();
    }

    public List<MyProduct> findMyProduct(Long customerId) {
        String str = "select u from MyProduct u   ";

        if(customerId != null ){
            str +=" where  u.customerId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(customerId != null) {
            query.setParameter("id", customerId);
        }
        return query.getResultList();
    }

    public List<Bill> findBillById(Long id, String paymentMethod, Integer page, Integer pageSize) {

        String str = "select u from Bill u  where u.isEnable = true";

        if(id != null ){
            str +=" and  u.customerId =:id";
        }
        if(paymentMethod != null ){
            str +=" and  u.paymentMethod =:paymentMethod";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        if(paymentMethod != null) {
            query.setParameter("paymentMethod", paymentMethod);
        }
        setPageInfo(query, page, pageSize);
        return query.getResultList();
    }

    public Long findBillCount(Long id,String paymentMethod) {
        String str = "select count(u.id) from Bill u  where u.isEnable = true";
        if(id != null ){
            str +=" and  u.customerId =:id";
        }
        if(paymentMethod != null ){
            str +=" and  u.paymentMethod =:paymentMethod";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        if(paymentMethod != null) {
            query.setParameter("paymentMethod", paymentMethod);
        }
        return (Long) query.getSingleResult();
    }

    public List<ProblemDescriptionJson> findAllProblem() {
        String str = "select new com.mry.json.store.ProblemDescriptionJson(u.id,u.problem) from ProblemDescription u  where u.isEnable = true";

        str +=" order by u.oder desc";
        Query query = getEntityManager().createQuery(str);

        return query.getResultList();
    }

    public List<MyProblemCheck> findMyProblem(Long id, Integer page, Integer pageSize) {
        String str = "select u from MyProblemCheck u  where u.isEnable = true";

        if(id != null ){
            str +=" and  u.customerId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }

        setPageInfo(query, page, pageSize);
        return query.getResultList();
    }

    public Long findMyProblemCount(Long id) {
        String str = "select count(u.id) from MyProblemCheck u  where u.isEnable = true";

        if(id != null ){
            str +=" and  u.customerId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return (Long) query.getSingleResult();
    }

    public ProblemDescription findProblemById(Long id) {
        String queryString = "SELECT u FROM ProblemDescription u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<ProblemDescription> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public MyProblemCheck findMyProblemById(Long id) {

        String queryString = "SELECT u FROM MyProblemCheck u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<MyProblemCheck> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<CorrespondencePlan> findByProblem(Long id,String programme) {

        String str = "select u from CorrespondencePlan u  where u.isEnable = true";

        if(id != null ){
            str +=" and  u.problemId =:id";
        }
        if(programme != null ){
            str +=" and  u.programType =:programme";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }

        if(programme != null) {
            query.setParameter("programme", programme);
        }
        return query.getResultList();
    }
}
