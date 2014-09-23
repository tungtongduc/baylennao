package de.txa.eventmanager.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.txa.eventmanager.entity.EventEntity;
import de.txa.eventmanager.service.EventDAO;

@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class EventDAOImpl extends BaseDAOImpl<EventEntity> implements EventDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> findByEventName(String eventName) {
		Query q = em.createQuery("SELECT e FROM EventEntity e WHERE e.eventName=:eventName");
		q.setParameter("eventName", eventName);
		return (List<EventEntity>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> findByUserId(Long id) {
		Query q = em.createQuery("SELECT u FROM UserEntity u WHERE u.id=:id");
		q.setParameter("id", id);
		return (List<EventEntity>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> findByDate(Date date) {
		Query q = em.createQuery("SELECT e FROM EventEntity e WHERE e.eventDate=:date");
		q.setParameter("date", date);
		return (List<EventEntity>) q.getResultList();
	}	
}
