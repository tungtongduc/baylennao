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
	public List<String> getAllInvitedMember(Long eventId);
	public List<String> getAllAcceptedMember(Long eventId, boolean isAccept);
	public void inviteUserToEvent(String userEmail, Long EventId);
	public void acceptInvite(String userEmail, Long EventId, boolean isAccept);
	public List<EventDTO> getAllInvitesFromUser(String userEmail);
}
