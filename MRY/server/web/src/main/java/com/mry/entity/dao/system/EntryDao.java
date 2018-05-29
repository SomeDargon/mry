package com.mry.entity.dao.system;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.EntryInformation;
import com.mry.json.system.EntryJson;
import com.mry.json.system.EntryListJson;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/12/28.
 */
@SuppressWarnings("unchecked")
@Repository
public class EntryDao extends AbstractDao<Object> {


    public EntryInformation findById(Long id) {

        String queryString = "SELECT u FROM EntryInformation u WHERE u.isEnable=true ";
        if(id !=null){
            queryString +=" and u.id =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(id !=null){
            query.setParameter("id",id);
        }
        List<EntryInformation> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<EntryListJson> findEntry(Long id,String name) {

        String str = "select new com.mry.json.system.EntryListJson(u.id,u.entryName,u.entryExplain,u.storeName,u.storeId) from EntryInformation u  where u.isEnable = true";

        if(name != null && name != ""){
            str +=" and  u.entryName like '%"+name+"%'";
        }
        if(id != null){
            str +=" and  u.storeId =:id";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        if(id != null){
            query.setParameter("id", id);
        }
        return query.getResultList();
    }

    public int delete(Long id) {
        String querString = "UPDATE EntryInformation a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }
}
