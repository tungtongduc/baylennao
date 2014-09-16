package de.txa.eventmanager.service;

import java.util.List;

import de.txa.eventmanager.entity.EventEntity;

public interface EventDAO extends BaseDAO<EventEntity>{
	public List<EventEntity> findByEventName(String eventname);
}
