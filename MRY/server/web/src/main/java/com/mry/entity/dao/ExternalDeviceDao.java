package com.mry.entity.dao;

import com.mry.entity.config.ExternalDevice;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * @author vito
 * @version 1.0
 * 创建时间 2016/4/11 12:27
 */
@SuppressWarnings("unchecked")
@Repository
public class ExternalDeviceDao extends AbstractDao<ExternalDevice> {

    /**
     * 通过机器编码获取设备
     *
     * @param machineId
     * @return
     */
    public ExternalDevice findDeviceByMachineId(String machineId) {
        String queryString = "SELECT u FROM ExternalDevice u WHERE u.isActive=true and u.machineId=:machineId";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("machineId", machineId);
        List<ExternalDevice> list = query.getResultList();
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 获取设备总数
     *
     * @return
     */
    public Long getDeviceCount() {
        String queryString = "select count(u.id) from ExternalDevice u where u.isActive=true";
        Query query = getEntityManager().createQuery(queryString);
        return (Long) query.getSingleResult();
    }

    /**
     * 获取设备分页集合
     *
     * @param page
     * @param pageSize
     * @return
     */
    public List<ExternalDevice> getDeviceListPage(Integer page, Integer pageSize) {
        String queryString = "select u from ExternalDevice u where u.isActive=true";
        Query query = getEntityManager().createQuery(queryString);
        setPageInfo(query, page, pageSize);
        return query.getResultList();
    }
}
