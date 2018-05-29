package com.mry.entity.dao.system;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.card.ExtensionCardManagement;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2018/1/3.
 */
@SuppressWarnings("unchecked")
@Repository
public class ExtensionDao extends AbstractDao<Object> {


    public ExtensionCardManagement findById(Long id) {


        String queryString = "SELECT u FROM ExtensionCardManagement u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<ExtensionCardManagement> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteProjectByEx(Long id) {

        String querString = "delete FROM  ExtensionCardProject u where   u.card.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public int delete(Long id) {

        String querString = "UPDATE ExtensionCardManagement a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public List<ExtensionCardManagement> findExtension(Long storeId,String name) {
        String str = "select u from ExtensionCardManagement u  where u.isEnable = true";
        if(storeId != null){
            str +=" and  u.storeId =:storeId";
        }
        if(name != null && name !="") {
            str +=" and  u.extensionName like '%"+name+"%'";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        query.setParameter("storeId", storeId);
        return query.getResultList();
    }
}
