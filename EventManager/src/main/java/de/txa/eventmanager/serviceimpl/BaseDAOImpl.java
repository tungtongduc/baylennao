package de.txa.eventmanager.serviceimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.txa.eventmanager.service.BaseDAO;

@Component
@Transactional(propagation = Propagation.SUPPORTS)
public abstract class BaseDAOImpl<T> implements BaseDAO<T>{
	
	@PersistenceContext(unitName="eventManager")
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
	public void delete(Long id, Class<T> T) {
		em.remove(em.merge(em.find(T, id)));
	}

	@Override
	public T findById(Long id, Class<T> T) {
			T entity = (T) em.find(T, id);
			return entity;
	}
}
