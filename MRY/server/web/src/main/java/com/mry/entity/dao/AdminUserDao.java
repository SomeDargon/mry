package com.mry.entity.dao;

import com.mry.entity.admin.AdminUser;
import com.mry.entity.admin.AdminUserSession;
import com.mry.entity.common.UserSession;
import com.mry.entity.user.data.UserType;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2017/4/27.
 */
@SuppressWarnings("unchecked")
@Repository
public class AdminUserDao extends  AbstractDao<Object>{

    public UserSession findUserSessionByAuthToken(String authToken, UserType type) {
        String queryString = "SELECT u FROM " + type.getSessionClass().getName() + " u WHERE u.authToken=:authToken "
                + " AND u.isExpired=:expired ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("authToken", authToken);
        query.setParameter("expired", false);

        List<UserSession> list = query.getResultList();
        return list.size() == 0 ? null : list.get(0);
    }


    public AdminUserSession findAdminUserSessionByAuthToken(String authToken) {
        String queryString = "SELECT u FROM AdminUserSession u" + " WHERE u.authToken=:authToken "
                + " AND u.isExpired=:expired ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("authToken", authToken);
        query.setParameter("expired", false);

        List<AdminUserSession> list = query.getResultList();
        return list.size() == 0 ? null : list.get(0);
    }

    public AdminUser findAdminUser(String username) {
        Query query = getEntityManager()
                .createQuery("SELECT a FROM AdminUser a WHERE a.username=:username AND a.isActive=true ");
        query.setParameter("username", username);
        List<AdminUser> users = query.getResultList();
        return users.size() == 0 ? null : users.get(0);
    }

    public Long countCustomers(String name, Long cityId) {
        String queryString = "SELECT COUNT(u.id) FROM  Customer u WHERE u.isActive=true ";
        if (name != null) {
            queryString += " AND (u.username LIKE :account OR u.realName LIKE :realName) ";
        }

        if (cityId != null) {
            queryString += " AND u.city.id=:cityId";
        }

        Query query = getEntityManager().createQuery(queryString);
        if (name != null) {
            query.setParameter("account", "%" + name + "%");
            query.setParameter("realName", "%" + name + "%");
        }

        if (cityId != null) {
            query.setParameter("cityId", cityId);
        }

        return (Long) query.getSingleResult();
    }

    public void invalidAdminSessions(AdminUser user) {
        String queryString = "UPDATE AdminUserSession u SET u.isExpired=true WHERE u.admin.id=:aid";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("aid", user.getId());

        query.executeUpdate();
    }

    public int deleteAdminUser(Long id){
        String querString = "UPDATE AdminUser a SET a.isActive=false WHERE a.id =:id";
        Query query = getEntityManager().createQuery(querString);
        query.setParameter("id", id);
        int res=query.executeUpdate();
        return res;
    }

    public Long getSensitiveWordList(String sensitiveName){
        StringBuilder builder = new StringBuilder("SELECT count(s.id) FROM SensitiveWord s");
        if (StringUtils.isNotBlank(sensitiveName)){
            builder.append(" where s.name like :sensitiveName ");
        }
        Query query = getEntityManager().createQuery(builder.toString());
        if(StringUtils.isNotBlank(sensitiveName)) {
            query.setParameter("sensitiveName", "%" + sensitiveName + "%");
        }
        return (Long) query.getSingleResult();
    }

    public Long getAuditLogCount(String adminName, Date beginDate,Date endDate,String Ip){
        StringBuilder builder = new StringBuilder("SELECT count(a.id) FROM AuditLog a");
        if(StringUtils.isNotBlank(adminName)||(beginDate!=null&&endDate!=null)||StringUtils.isNotBlank(Ip)){
            builder.append(" where ");
        }
        if (StringUtils.isNotBlank(adminName)){
            builder.append(" a.admin.username LIKE :adminName ");
        }
        if(StringUtils.isNotBlank(adminName)&&beginDate!=null&&endDate!=null){
            builder.append(" and");
        }
        if(beginDate!=null&&endDate!=null){
            builder.append("  a.operatingTime>=:beginDate and a.operatingTime<=:endDate ");
        }
        if(((StringUtils.isNotBlank(adminName))||(beginDate!=null&&endDate!=null))&&StringUtils.isNotBlank(Ip)){
            builder.append(" and");
        }
        if(StringUtils.isNotBlank(Ip)){
            builder.append("  a.Ip like :Ip ");
        }
        Query query = getEntityManager().createQuery(builder.toString());
        if(StringUtils.isNotBlank(adminName)) {
            query.setParameter("adminName", "%" + adminName + "%");
        }
        if(beginDate!=null&&endDate!=null){
            query.setParameter("beginDate",beginDate);
            query.setParameter("endDate",endDate);
        }
        if(StringUtils.isNotBlank(Ip)){
            query.setParameter("Ip","%"+Ip+"%");
        }
        return (Long) query.getSingleResult();
    }

    public Long getAllCustomerCount(String userName){
        StringBuilder builder = new StringBuilder("SELECT count(c.id) FROM CustomerMembersEnjoy c");
        if(StringUtils.isNotBlank(userName)){
            builder.append(" where c.username like :userName");
        }
        Query query = getEntityManager().createQuery(builder.toString());
        if(StringUtils.isNotBlank(userName)){
            query.setParameter("userName","%"+userName+"%");
        }
        return (Long) query.getSingleResult();
    }

}
