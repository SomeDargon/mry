package com.mry.entity.dao;

import com.mry.entity.admin.AdminUserSession;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public class UserDao extends AbstractDao<Object> {

    public AdminUserSession findAdminUserSessionByAuthToken(String authToken) {
        String queryString = "SELECT u FROM AdminUserSession u" + " WHERE u.authToken=:authToken "
                + " AND u.isExpired=:expired ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("authToken", authToken);
        query.setParameter("expired", false);

        List<AdminUserSession> list = query.getResultList();
        return list.size() == 0 ? null : list.get(0);
    }





}
