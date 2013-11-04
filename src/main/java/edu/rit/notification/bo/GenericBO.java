package edu.rit.notification.bo;

import java.util.List;

public interface GenericBO<T, ID> {

	public T persist(T entity) throws Exception;

	public void delete(T entity) throws Exception;

	public T find(ID id) throws Exception;

	public List<T> findAll() throws Exception;

	public int count();
}
