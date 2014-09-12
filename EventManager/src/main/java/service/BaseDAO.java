package service;

public interface BaseDAO<T> {
	
	public void create(T entity);
	public void update(T entity);
	public void delete(long id);
	public T findById(long id, Class<T> T);
	
}