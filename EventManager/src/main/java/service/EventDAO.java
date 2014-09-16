package service;

import java.util.List;

import dto.EventDTO;

public interface EventDAO {
	public void create(EventDTO eventDTO);
	public void update(EventDTO eventDTO);
	public void delete(long id);
	public List<EventDTO> findByEventName(String eventname);
	public EventDTO findByEventId(long id);
}
