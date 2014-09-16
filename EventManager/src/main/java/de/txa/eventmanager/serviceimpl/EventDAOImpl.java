package de.txa.eventmanager.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Component;

import de.txa.eventmanager.dto.EventDTO;
import de.txa.eventmanager.entity.EventEntity;
import de.txa.eventmanager.service.EventDAO;

@Component
public class EventDAOImpl extends BaseDAOImpl<EventEntity> implements EventDAO{

	@Override
	public List<EventDTO> findByEventName(String eventname) {
		// TODO Auto-generated method stub
		return null;
	}

}
