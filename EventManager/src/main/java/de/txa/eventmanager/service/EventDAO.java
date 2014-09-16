package de.txa.eventmanager.service;

import java.util.List;

import de.txa.eventmanager.dto.EventDTO;
import de.txa.eventmanager.entity.EventEntity;

public interface EventDAO extends BaseDAO<EventEntity>{
	public List<EventDTO> findByEventName(String eventname);
}
