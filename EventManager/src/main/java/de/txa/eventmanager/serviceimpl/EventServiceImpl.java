package de.txa.eventmanager.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.txa.eventmanager.dto.ConvertEvent;
import de.txa.eventmanager.dto.EventDTO;
import de.txa.eventmanager.entity.EventEntity;
import de.txa.eventmanager.entity.JoinInEntity;
import de.txa.eventmanager.service.EventDAO;
import de.txa.eventmanager.service.EventService;
import de.txa.eventmanager.service.JoinInDAO;

@Component
@Transactional("txEvent")
public class EventServiceImpl implements EventService {
	@Inject
	private EventDAO eventDao;
	
	@Inject
	private JoinInDAO joinInDAO;
	
	@Override
	public void create(EventDTO eventDTO) {
		eventDTO.setUpdateDate(new Date());
		eventDao.create(eventDTO.convertToEventEntity());
	}

	@Override
	public void delete(Long id) {
		eventDao.delete(id, EventEntity.class);
	}

	@Override
	public void update(EventDTO eventDTO) {
		eventDTO.setUpdateDate(new Date());
		eventDao.update(eventDTO.convertToEventEntity());
	}

	@Override
	public List<EventDTO> findByEventName(String eventname) {		
		return ConvertEvent.convertToListEventDTO(eventDao.findByEventName(eventname));
	}

	@Override
	public EventDTO findByEventID(Long id) {
		return ConvertEvent.convertToEventDTO(eventDao.findById(id, EventEntity.class));
	}

	@Override
	public List<EventDTO> findByUserEmail(String userEmail) {
		return ConvertEvent.convertToListEventDTO(eventDao.findByUserEmail(userEmail));
	}

	@Override
	public List<EventDTO> findByDate(Date date) {
		return ConvertEvent.convertToListEventDTO(eventDao.findByDate(date));
	}

	@Override
	public List<String> getAllInvitedMember(Long EventID) {
		final List<String> members = new ArrayList<String>();
		final EventEntity event = eventDao.findById(EventID, EventEntity.class);
		if(event != null) {
			final List<JoinInEntity> joinIn = event.getInvites();
			for(JoinInEntity jn : joinIn) {
				members.add(jn.getUserEmail());
			}
		}
		return members;
	}

	@Override
	public List<String> getAllAcceptedMember(Long EventID) {
		final List<String> members = new ArrayList<String>();
		final EventEntity event = eventDao.findById(EventID, EventEntity.class);
		if(event != null) {
			final List<JoinInEntity> joinIn = event.getInvites();
			for(JoinInEntity jn : joinIn) {
				if(jn.getAccept()) 
					members.add(jn.getUserEmail());
			}
		}
		return members;
	}

	@Override
	public void inviteUserToEvent(String userEmail, Long EventId) {
		if(joinInDAO.findInvite(userEmail, EventId) == null) {
			final EventEntity event = eventDao.findById(EventId, EventEntity.class);
			if(event != null) {
				final JoinInEntity joinInEntity = new JoinInEntity();
				joinInEntity.setAccept(false);
				joinInEntity.setUpdatedOnDate(new Date());
				joinInEntity.setUserEmail(userEmail);
				event.addJoinIn(joinInEntity);
				eventDao.update(event);
			}
		}
	}

	@Override
	public void acceptInvite(String userEmail, Long EventId) {
		final JoinInEntity joinInEntity = joinInDAO.findInvite(userEmail, EventId);
		if(joinInEntity != null) {
			joinInEntity.setAccept(true);
			joinInDAO.update(joinInEntity);
		}
	}

	@Override
	public List<EventDTO> getAllInvites(String userEmail) {
		return ConvertEvent.convertToListEventDTO(joinInDAO.getAllInvites(userEmail));
	}
}
