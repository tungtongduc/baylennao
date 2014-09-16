package de.txa.eventmanager.service;

import java.util.List;

import de.txa.eventmanager.dto.EventDTO;

public interface EventService {
	public void create(EventDTO eventDTO);
	public void delete(Long id);
	public void update(EventDTO eventDTO);
	public List<EventDTO> findByEventName(String name);
	public EventDTO findByEventID(long id);
}
