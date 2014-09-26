package de.txa.eventmanager.service;

import java.util.List;

import de.txa.eventmanager.entity.EventEntity;
import de.txa.eventmanager.entity.JoinInEntity;

public interface JoinInDAO extends BaseDAO<JoinInEntity>{

	public JoinInEntity findInvite(String userEmail, Long EventId);
	public List<EventEntity> getAllInvites(String userEmail);
	public List<String> getAllInvitedMember(Long eventId);
	public List<String> getAllAcceptedMember(Long eventId, boolean isAccept);
}
