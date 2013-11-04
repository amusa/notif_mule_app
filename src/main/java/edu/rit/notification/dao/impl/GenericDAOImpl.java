package edu.rit.notification.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import edu.rit.notification.dao.GenericDAO;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements
		GenericDAO<T, ID> {
	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> entityClass;
	//LocalSessionFactoryBean d;

	public GenericDAOImpl() {
	}

	public GenericDAOImpl(Class<T> entityClass) {
		System.out.println("setting entityClass " + entityClass);
		this.entityClass = entityClass;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public T findById(ID id) {
		T entity;
		entity = (T) getCurrentSession().get(getEntityClass(), id);
		return entity;
	}

	public List<T> findAll() {
		System.out.println("In Generic findAll method");
		return findByCriteria();
	}

	public T merge(T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	public T persist(T entity) {
		getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	public void remove(T entity) {
		getCurrentSession().delete(entity);

	}

	public Criteria createCriteria() {
		System.out.println("getEntityClass " + entityClass);
		return getCurrentSession().createCriteria(getEntityClass());
	}

	protected List<T> findByCriteria(final Criterion... criterion) {
		Criteria crit = createCriteria();
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}
	

}
