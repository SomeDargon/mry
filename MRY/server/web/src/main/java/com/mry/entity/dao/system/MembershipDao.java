package com.mry.entity.dao.system;

import com.mry.entity.dao.AbstractDao;
import com.mry.entity.store.card.MembershipCardManagement;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by kaik on 2018/1/3.
 * 会员卡管理
 */
@SuppressWarnings("unchecked")
@Repository
public class MembershipDao extends AbstractDao<Object> {


    public MembershipCardManagement findById(Long id) {

        String queryString = "SELECT u FROM MembershipCardManagement u WHERE u.id=:id ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);

        List<MembershipCardManagement> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    public int deleteCardProject(Long id) {
        String querString = "delete FROM  MembersEnjoy u where   u.card.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public List<MembershipCardManagement> findMembership(Long storeId,String name) {

        String str = "select u from MembershipCardManagement u  where u.isEnable = true";
        if(storeId != null) {
            str +=" and  u.storeId =:id";
        }
        if(name != null && name !="") {
            str +=" and  u.membershipName like '%"+name+"%'";
        }
        str +=" order by u.id desc";
        Query query = getEntityManager().createQuery(str);
        query.setParameter("id", storeId);
        return query.getResultList();
    }

    public int delete(Long id) {
        String querString = "UPDATE MembershipCardManagement a SET a.isEnable=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public MembershipCardManagement findMinMembershipCardById(Long storeId) {


        String queryString = "SELECT u FROM MembershipCardManagement u WHERE u.isEnable = true and u.projectDiscount = (SELECT MIN(m.projectDiscount) FROM MembershipCardManagement m) ";
        if(storeId != null) {
            queryString +=" and  u.storeId =:id";
        }
        Query query = getEntityManager().createQuery(queryString);
        if(storeId != null) {
            query.setParameter("id", storeId);
        }
        List<MembershipCardManagement> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;

    }
}
