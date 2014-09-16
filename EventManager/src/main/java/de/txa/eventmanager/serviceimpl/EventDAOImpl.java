package de.txa.eventmanager.serviceimpl;

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
		return (List<EventEntity>) q.getResultList();
	}
}
