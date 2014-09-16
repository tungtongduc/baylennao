package service;

import java.util.List;

import dto.EventDTO;

public interface EventService {
	public void create(EventDTO eventDTO);
	public void delete(EventDTO eventDTO);
	public void update(long id);
	public List<EventDTO> findByEventName(String name);
	public EventDTO findByEventID(long id);
}
