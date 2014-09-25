package de.txa.eventmanager.dto;

import java.util.ArrayList;
import java.util.List;

import de.txa.eventmanager.entity.EventEntity;
import de.txa.eventmanager.entity.JoinInEntity;

public class ConvertEvent {
	public static EventDTO convertToEventDTO(EventEntity evententity) {
		final EventDTO eventDto = new EventDTO(evententity.getId(), evententity.getEventName(),
				evententity.getEventContent(), evententity.getEventDate(),
				evententity.getEventLocation(), evententity.getEventIcon());
			eventDto.setId(evententity.getId());
			eventDto.setHostEmail(evententity.getHostEmail());
		eventDto.setInvites(convertToListJoinInDTO(evententity.getInvites()));
		eventDto.setCreatedate(evententity.getCreatedOnDate());
		eventDto.setUpdateDate(evententity.getUpdatedOnDate());
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
	
	public static JoinInDTO convertToJoinInDTO(JoinInEntity joinInEntity){
		final JoinInDTO joinInDTO = new JoinInDTO(joinInEntity.getId(), 
							joinInEntity.getAccept(), 
							joinInEntity.getUserEmail(), 
							joinInEntity.getCreatedOnDate(), 
							joinInEntity.getUpdatedOnDate());
		joinInDTO.setEventDto(convertToEventDTO(joinInEntity.getEventEntity()));
		return joinInDTO;
	}
	
	public static List<JoinInDTO> convertToListJoinInDTO(List<JoinInEntity> joinInEntities) {
		final List<JoinInDTO> joinInDTOs = new ArrayList<JoinInDTO>();
		for(JoinInEntity joinInEntity: joinInEntities) {
			joinInDTOs.add(convertToJoinInDTO(joinInEntity));
		}
		return joinInDTOs;
	}
}
