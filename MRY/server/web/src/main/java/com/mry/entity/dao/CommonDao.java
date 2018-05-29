package com.mry.entity.dao;

import com.mry.entity.common.City;
import com.mry.entity.common.Province;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public class CommonDao extends AbstractDao<Object> {
	public List<Province> getAllProvinces() {
		String queryString = "SELECT p FROM Province p WHERE p.isActive=true ";
		Query query = getEntityManager().createQuery(queryString);
		return query.getResultList();
	}

	public List<City> findCitiesByProvinceId(Long provinceId) {
		String queryString = "SELECT p FROM City p WHERE p.province.id=:pid AND p.isActive=true ";
		Query query = getEntityManager().createQuery(queryString);
		query.setParameter("pid", provinceId);
		return query.getResultList();
	}

	public Long getBulletinCount(Date start, Date end) {
		StringBuilder builder = new StringBuilder("SELECT count(p.id) FROM Bulletin p WHERE p.isActive=true ");
		if (start != null && end != null) {
			builder.append(" AND p.addTime >= :start AND p.addTime <= :end ");
		}

		Query query = getEntityManager().createQuery(builder.toString());
		if (start != null && end != null) {
			query.setParameter("start", start);
			query.setParameter("end", end);
		}

		return (Long) query.getSingleResult();
	}

	public Long getAdminUserCount(String userName){
		StringBuilder builder = new StringBuilder("SELECT count(a.id) FROM AdminUser a WHERE a.isActive=true ");
		if(userName!=null){
			builder.append(" AND a.username LIKE :userName ");
		}
		Query query = getEntityManager().createQuery(builder.toString());
		if(userName!=null){
			query.setParameter("userName", "%" + userName + "%");
		}
		return (Long) query.getSingleResult();
	}



	public City getCityById(Long cityId) {
		return find(City.class, cityId);
	}



	public boolean checkCityExist(String name, Long provinceId) {
		Query query = getEntityManager().createQuery(
				"SELECT c FROM City c WHERE lower(c.name)=lower(:name) AND c.isActive=true AND c.province.id=:pid AND c.province.isActive=true ");
		query.setParameter("name", name);
		query.setParameter("pid", provinceId);

		return query.getResultList().size() > 0;
	}


	public List<City> findAllCities() {
		String queryString = "SELECT c FROM City c WHERE c.isActive=true ";

		Query query = getEntityManager().createQuery(queryString);

		List<City> list = query.getResultList();
		return list;
	}



	public Long findCityIdByName(String city) {
		Query query = getEntityManager()
				.createQuery("SELECT c.id FROM City c WHERE c.name LIKE :name AND c.isActive=true");
		query.setParameter("name", city + "%");
		List<Object> list = query.getResultList();
		return list.size() > 0 ? (Long) list.get(0) : null;
	}


	public Long getIdNumber(String idNumber){
		String queryString = "SELECT COUNT(c.id) FROM Customer c WHERE c.idCardNumber=:idNumber";
		Query query = getEntityManager().createQuery(queryString);
		query.setParameter("idNumber",idNumber);
		return (Long) query.getSingleResult();
	}

}
