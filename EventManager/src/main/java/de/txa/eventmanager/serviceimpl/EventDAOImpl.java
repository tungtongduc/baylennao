package de.txa.eventmanager.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import de.txa.eventmanager.entity.EventEntity;
import de.txa.eventmanager.entity.JoinInEntity;
import de.txa.eventmanager.service.EventDAO;

@Component
public class EventDAOImpl extends BaseDAOImpl<EventEntity> implements EventDAO{

	private static final int FIRST_INDEX = 0;

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

	@SuppressWarnings("unchecked")
	@Override
	public JoinInEntity findInvite(String userEmail, Long eventId) {
		Query q = em.createQuery("SELECT jn FROM EventEntity e join e.invites jn WHERE e.id=:eventId and jn.userEmail=:userEmail");
		q.setParameter("eventId", eventId);
		q.setParameter("userEmail", userEmail);
		final List<JoinInEntity> joinInEntities = q.getResultList();
		return !CollectionUtils.isEmpty(joinInEntities) ? joinInEntities.get(FIRST_INDEX) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> getAllInvites(String userEmail) {
		Query q = em.createQuery("SELECT e FROM EventEntity e join e.invites jn WHERE jn.userEmail=:userEmail");
		q.setParameter("userEmail", userEmail);
		return q.getResultList();
	}
}
