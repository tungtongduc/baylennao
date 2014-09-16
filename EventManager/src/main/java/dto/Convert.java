package dto;

import java.util.ArrayList;
import java.util.List;

import de.txa.eventmanager.entity.EventEntity;

public class Convert {
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
			eventDTOList.add(Convert.convertToEventDTO(evententity));
		}
		return eventDTOList;
	}
}
