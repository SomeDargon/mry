package com.mry.entity.dao.system;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.card.ProductCardManagement;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2018/1/10.
 */
@SuppressWarnings("unchecked")
@Repository
public class ProductCardDao extends AbstractDao<Object> {


    public ProductCardManagement findById(Long id) {
        String queryString = "SELECT u FROM ProductCardManagement u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<ProductCardManagement> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<ProductCardManagement> findproductCard(Long storeId,String name) {

        String str = "select u from ProductCardManagement u  where u.isEnable = true";
        if(storeId !=null){
            str +=" and u.storeId =:id";
        }
        if(name != null && name !="") {
            str +=" and  u.productCardName like '%"+name+"%'";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        query.setParameter("id",storeId);
        return query.getResultList();
    }

    public int delete(Long id) {

        String querString = "UPDATE ProductCardManagement a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }
}
