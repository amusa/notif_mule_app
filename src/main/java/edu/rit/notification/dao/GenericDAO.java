package edu.rit.notification.dao;

import java.util.List;
import org.hibernate.Session;

public interface GenericDAO<T, ID> {

	public Class<T> getEntityClass();

	public Session getCurrentSession();

	public T findById(ID id);

	public List<T> findAll();

	public T merge(T entity);

	public T persist(T entity);

	public void remove(T entity);
}
