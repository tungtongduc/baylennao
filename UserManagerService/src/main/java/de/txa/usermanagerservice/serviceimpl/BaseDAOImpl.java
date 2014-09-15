package de.txa.usermanagerservice.serviceimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.txa.usermanagerservice.service.BaseDAO;

@Transactional(propagation = Propagation.SUPPORTS)
public abstract class BaseDAOImpl<T> implements BaseDAO<T>{
	
	@PersistenceContext
	protected EntityManager em;

	
	@Override
	public void create(final T entity){
			em.persist(entity);
	}

	@Override
	public void update(T entity){
			em.merge(entity);
	}

	@Override
	public void delete(long id, Class<T> T) {
		em.remove(em.merge(em.find(T, id)));
	}

	@Override
	public T findById(long id, Class<T> T) {
			T entity = (T) em.find(T, id);
			return entity;
	}
}
