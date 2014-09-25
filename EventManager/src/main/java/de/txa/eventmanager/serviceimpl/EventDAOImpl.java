package de.txa.eventmanager.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import de.txa.eventmanager.entity.EventEntity;
import de.txa.eventmanager.service.EventDAO;

@Component
public class EventDAOImpl extends BaseDAOImpl<EventEntity> implements EventDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> findByEventName(String eventName) {
		Query q = em.createQuery("SELECT e FROM EventEntity e WHERE e.eventName=:eventName");
		q.setParameter("eventName", eventName);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> findByUserEmail(String userEmail) {
		Query q = em.createQuery("SELECT e FROM EventEntity e WHERE e.hostEmail=:userEmail");
		q.setParameter("userEmail", userEmail);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> findByDate(Date date) {
		Query q = em.createQuery("SELECT e FROM EventEntity e WHERE e.eventDate=:date");
		q.setParameter("date", date);
		return q.getResultList();
	}
}
