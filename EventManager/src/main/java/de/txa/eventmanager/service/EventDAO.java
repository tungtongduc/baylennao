package de.txa.eventmanager.service;

import java.util.Date;
import java.util.List;

import de.txa.eventmanager.entity.EventEntity;
import de.txa.eventmanager.entity.JoinInEntity;

public interface EventDAO extends BaseDAO<EventEntity>{
	public List<EventEntity> findByEventName(String eventname);
	public List<EventEntity> findByUserEmail(String userEmail);
	public List<EventEntity> findByDate(Date date);
	public JoinInEntity findInvite(String userEmail, Long EventId);
	public List<EventEntity> getAllInvites(String userEmail);
}
