package de.txa.usermanager.service;

public interface BaseDAO<T> {
	
	public void create(T entity);
	public void update(T entity);
	public void delete(Long id, Class<T> T);
	public T findById(Long id, Class<T> T);
	
}
