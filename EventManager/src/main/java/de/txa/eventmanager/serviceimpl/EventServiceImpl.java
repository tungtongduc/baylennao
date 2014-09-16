package de.txa.eventmanager.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.txa.eventmanager.dto.ConvertEvent;
import de.txa.eventmanager.dto.EventDTO;
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
	public void delete(EventDTO eventDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EventDTO> findByEventName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventDTO findByEventID(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
