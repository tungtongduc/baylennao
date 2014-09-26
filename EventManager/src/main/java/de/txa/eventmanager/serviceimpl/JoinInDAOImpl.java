package de.txa.eventmanager.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import de.txa.eventmanager.entity.EventEntity;
import de.txa.eventmanager.entity.JoinInEntity;
import de.txa.eventmanager.service.JoinInDAO;

@SuppressWarnings("unchecked")
@Component
public class JoinInDAOImpl extends BaseDAOImpl<JoinInEntity> implements JoinInDAO{

	private static final int FIRST_INDEX = 0;
	
	@Override
	public JoinInEntity findInvite(String userEmail, Long eventId) {
		Query q = em.createQuery("SELECT jn FROM JoinInEntity jn WHERE jn.eventEntity.id=:eventId and jn.userEmail=:userEmail");
		q.setParameter("eventId", eventId);
		q.setParameter("userEmail", userEmail);
		final List<JoinInEntity> joinInEntities = q.getResultList();
		return !CollectionUtils.isEmpty(joinInEntities) ? joinInEntities.get(FIRST_INDEX) : null;
	}

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

	@Override
	public List<String> getAllInvitedMember(Long eventId) {
		Query q = em.createQuery("SELECT jn FROM JoinInEntity jn WHERE jn.eventEntity.id=:eventId");
		q.setParameter("eventId", eventId);
		return getListMemberFromJoinInEntity(q.getResultList());
	}

	@Override
	public List<String> getAllAcceptedMember(Long eventId, boolean isAccept) {
		Query q = em.createQuery("SELECT jn FROM JoinInEntity jn WHERE jn.eventEntity.id=:eventId and jn.accept=:isAccept");
		q.setParameter("eventId", eventId);
		q.setParameter("isAccept", isAccept);
		return getListMemberFromJoinInEntity(q.getResultList());
	}
	
	private List<String> getListMemberFromJoinInEntity(List<JoinInEntity> joinInEntities) {
		final List<String> members = new ArrayList<String>();
		for(JoinInEntity jn : joinInEntities) {
			members.add(jn.getUserEmail());
		}
		return members;
	}
}
