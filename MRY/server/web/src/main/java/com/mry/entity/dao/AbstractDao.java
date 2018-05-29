package com.mry.entity.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mry.exception.BusinessException;
import com.mry.exception.ErrorCode;
import com.mry.util.Constants;

public abstract class AbstractDao<T> {

	@PersistenceContext(unitName = "persistence.mry")
	private EntityManager entityManager;

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return entityClass;
	}

	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public AbstractDao() {
	}

	public void flush()
	{
		entityManager.flush();
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void save(T entity) {
		this.entityManager.persist(entity);
	}

	public <OBJ> void saveObject(OBJ entity) {
		this.entityManager.persist(entity);
	}

	public T update(T entity) {
		return this.entityManager.merge(entity);
	}

	public <OBJ> OBJ	updateObject(OBJ entity) {
		return this.entityManager.merge(entity);
	}

	public void remove(T entity) {
		this.entityManager.remove(this.entityManager.merge(entity));
	}

	public void removeObject(Object entity) {
		this.entityManager.remove(this.entityManager.merge(entity));
	}

	public T find(Long primaryKey) {
		return this.entityManager.find(getEntityClass(), primaryKey);
	}

	public <R> R find(Class<R> clazz, Long primaryKey) {
		if (primaryKey == null) {
			return null;
		}
		return this.entityManager.find(clazz, primaryKey);
	}

	public <R> R find(Class<R> clazz, Long primaryKey, ErrorCode errorCode) {
		if (primaryKey == null) {
			throw new BusinessException(errorCode);
		}
		R obj = this.entityManager.find(clazz, primaryKey);
		if (obj == null) {
			throw new BusinessException(errorCode);
		}
		return obj;
	}

	protected void setPageInfo(Query query, Integer page, Integer pageSize) {
		page = (page == null || page < 1) ? Constants.DEFAULT_PAGE : page;
		pageSize = (pageSize == null || pageSize < 1) ? Constants.DEFAULT_PAGE_SIZE
				: pageSize;
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
	}
}
