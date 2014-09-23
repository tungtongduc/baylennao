package de.txa.eventmanager.service;

import java.util.Date;
import java.util.List;

import de.txa.eventmanager.entity.EventEntity;

public interface EventDAO extends BaseDAO<EventEntity>{
	public List<EventEntity> findByEventName(String eventname);
	public List<EventEntity> findByUserId(Long id);
	public List<EventEntity> findByDate(Date date);
}
