package de.txa.eventmanager.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.txa.eventmanager.dto.ConvertEvent;
import de.txa.eventmanager.dto.EventDTO;
import de.txa.eventmanager.entity.EventEntity;
import de.txa.eventmanager.service.EventDAO;
import de.txa.eventmanager.service.EventService;

@Component
@Transactional
public class EventServiceImpl implements EventService {
	@Inject
	private EventDAO eventDao;
	
	@Override
	public void create(EventDTO eventDTO) {
		eventDao.create(ConvertEvent.convertToEventEntity(eventDTO));
	}

	@Override
	public void delete(Long id) {
		eventDao.delete(id, EventEntity.class);
	}

	@Override
	public void update(EventDTO eventDTO) {
		eventDao.update(ConvertEvent.convertToEventEntity(eventDTO));
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
	public List<EventDTO> findByUserId(Long id) {
		return ConvertEvent.convertToListEventDTO(eventDao.findByUserId(id));
	}

	@Override
	public List<EventDTO> findByDate(Date date) {
		return ConvertEvent.convertToListEventDTO(eventDao.findByDate(date));
	}
}
