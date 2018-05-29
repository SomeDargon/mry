package com.mry.entity.dao.system;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.card.CardManagement;
import com.mry.entity.store.project.ProductManagement;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/12/5.
 */
@SuppressWarnings("unchecked")
@Repository
public class ProductDao extends AbstractDao<Object> {

    public ProductManagement findById(Long id) {
        String queryString = "SELECT u FROM ProductManagement u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<ProductManagement> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<ProductManagement> findAllProjectt(Long id) {
        String str = "select u from ProductManagement u  where u.isEnable = true";
        if(id != null) {
            str +=" and  u.storeId =:id";
        }

        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null) {
            query.setParameter("id", id);
        }
        return query.getResultList();
    }
}
