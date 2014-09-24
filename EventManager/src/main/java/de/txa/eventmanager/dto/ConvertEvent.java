package de.txa.eventmanager.dto;

import java.util.ArrayList;
import java.util.List;

import de.txa.eventmanager.entity.EventEntity;

public class ConvertEvent {
	public static EventDTO convertToEventDTO(EventEntity evententity) {
		final EventDTO eventDto = new EventDTO(evententity.getEventName(),
				evententity.getEventContent(), evententity.getEventDate(),
				evententity.getEventLocation(), evententity.getEventIcon());
			eventDto.setId(evententity.getId());
			eventDto.setHostEmail(evententity.getHostEmail());
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
		
	public static EventEntity convertToEventEntity(EventDTO eventDTO) {
		final EventEntity eventEntity = new EventEntity();
		eventEntity.setEventName(eventDTO.getEventName());
		eventEntity.setEventContent(eventDTO.getEventContent());
		eventEntity.setEventDate(eventDTO.getEventDate());
		eventEntity.setEventLocation(eventDTO.getEventLocation());
		eventEntity.setEventIcon(eventDTO.getEventIcon());
		eventEntity.setHostEmail(eventDTO.getHostEmail());
		return eventEntity;
	}
}
