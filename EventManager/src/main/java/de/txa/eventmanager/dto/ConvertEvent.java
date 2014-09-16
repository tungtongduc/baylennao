package de.txa.eventmanager.dto;

import java.util.ArrayList;
import java.util.List;

import de.txa.eventmanager.entity.EventEntity;

public class ConvertEvent {
	public static EventDTO convertToEventDTO(EventEntity evententity) {
		final EventDTO eventDto = new EventDTO(evententity.getEventName(),
				evententity.getEventContent(), evententity.getEventDate(),
				evententity.getEventLocation(), evententity.getEventIcon());
		return eventDto;
	}

	public static List<EventDTO> convertToListEventDTO(
			List<EventEntity> eventlist) {
		List<EventDTO> eventDTOList = new ArrayList<EventDTO>();
		for(EventEntity evententity : eventlist){
			eventDTOList.add(ConvertEvent.convertToEventDTO(evententity));
		}
		return eventDTOList;
	}
	
	//TODO
	public static EventEntity convertToEventEntity(EventDTO eventDTO) {
		return null;
	}
}
