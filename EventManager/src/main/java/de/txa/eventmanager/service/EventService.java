package de.txa.eventmanager.service;

import java.util.Date;
import java.util.List;

import de.txa.eventmanager.dto.EventDTO;

public interface EventService {
	public void create(EventDTO eventDTO);
	public void delete(Long id);
	public void update(EventDTO eventDTO);
	public List<EventDTO> findByEventName(String name);
	public EventDTO findByEventID(Long id);
	public List<EventDTO> findByUserEmail(String userEmail);
	public List<EventDTO> findByDate(Date date);
	public List<String> getAllInviteMember(Long EventID);
	public List<String> getAllAcceptedMember(Long EventID);
	public void inviteUserToEvent(String userEmail, Long EventId);
	public void userAccepteInvite(String userEmail, Long EventId);
	public List<EventDTO> getAllInvitedEvent(String userEmail);
	public List<EventDTO> getAllEventsOfUser(String userEmail);
}
