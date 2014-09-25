package de.txa.eventmanager.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import de.txa.eventmanager.entity.EventEntity;
import de.txa.eventmanager.entity.JoinInEntity;
import de.txa.eventmanager.service.JoinInDAO;

@Component
public class JoinInDAOImpl extends BaseDAOImpl<JoinInEntity> implements JoinInDAO{

	private static final int FIRST_INDEX = 0;
	
	@SuppressWarnings("unchecked")
	@Override
	public JoinInEntity findInvite(String userEmail, Long eventId) {
		Query q = em.createQuery("SELECT jn FROM JoinInEntity jn WHERE jn.eventEntity.id=:eventId and jn.userEmail=:userEmail");
		q.setParameter("eventId", eventId);
		q.setParameter("userEmail", userEmail);
		final List<JoinInEntity> joinInEntities = q.getResultList();
		return !CollectionUtils.isEmpty(joinInEntities) ? joinInEntities.get(FIRST_INDEX) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> getAllInvites(String userEmail) {
		Query q = em.createQuery("SELECT jn FROM JoinInEntity jn WHERE jn.userEmail=:userEmail");
		q.setParameter("userEmail", userEmail);
		final List<EventEntity> eventEntities = new ArrayList<EventEntity>();
		final List<JoinInEntity> joinInEntities = q.getResultList();
		for(JoinInEntity jn : joinInEntities) {
			eventEntities.add(jn.getEventEntity());
		}
		return eventEntities;
	}
}
