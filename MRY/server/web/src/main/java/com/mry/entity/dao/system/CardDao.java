package com.mry.entity.dao.system;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.card.CardManagement;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2017/11/29.
 */
@SuppressWarnings("unchecked")
@Repository
public class CardDao extends AbstractDao<Object> {
    public CardManagement findById(Long id) {
        String queryString = "SELECT u FROM CardManagement u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<CardManagement> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteCardProject(Long id) {
        String querString = "delete FROM  CardProject u where   u.card.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public int deleteGiftItems(Long id) {
        String querString = "delete FROM  GiftItems u where   u.card.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public List<CardManagement> findCards(String name, Integer page, Integer pageSize) {

        String str = "select u from CardManagement u  where u.isEnable = true";

        if(name != null && name != ""){
            str +=" and  u.realName like '%"+name+"%'";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);

        setPageInfo(query, page, pageSize);
        return query.getResultList();

    }

    public Long findCardsCount(String name) {
        String str = "select count(u.id) from Staff u  where u.isEnable = true";

        if(name != null && name != ""){
            str +=" and  u.realName like '%"+name+"%'";
        }
        Query query = getEntityManager().createQuery(str);

        return (Long) query.getSingleResult();
    }




}
