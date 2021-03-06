package de.txa.usermanager.serviceimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.txa.usermanager.service.BaseDAO;

public abstract class BaseDAOImpl<T> implements BaseDAO<T>{
	
	@PersistenceContext(unitName = "userManager")
	protected EntityManager em;

	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void create(T entity){
		em.persist(entity);
	}

	@Override
	public void update(T entity){
		em.merge(entity);
	}

	@Override
	public void delete(Long id, Class<T> T) {
		em.remove(em.merge(em.find(T, id)));
	}

	@Override
	public T findById(Long id, Class<T> T) {
		T entity = (T) em.find(T, id);
		return entity;
	}
}
