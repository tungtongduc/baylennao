package de.txa.eventmanager.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.txa.eventmanager.entity.JoinInEntity;

public class JoinInDTO {

	private Long id;
	private Boolean accept;
	private String userEmail;
	private Date createdOnDate;
	private Date updatedOnDate;
	private EventDTO eventDto;

	public JoinInDTO(Long id, Boolean accept, String userEmail,
			Date createdOnDate, Date updatedOnDate) {
		super();
		this.id = id;
		this.accept = accept;
		this.userEmail = userEmail;
		this.createdOnDate = createdOnDate;
		this.updatedOnDate = updatedOnDate;
	}
	
	public JoinInDTO(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAccept() {
		return accept;
	}

	public void setAccept(Boolean accept) {
		this.accept = accept;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getCreatedOnDate() {
		return createdOnDate;
	}

	public void setCreatedOnDate(Date createdOnDate) {
		this.createdOnDate = createdOnDate;
	}

	public Date getUpdatedOnDate() {
		return updatedOnDate;
	}

	public void setUpdatedOnDate(Date updatedOnDate) {
		this.updatedOnDate = updatedOnDate;
	}
	
	public EventDTO getEventDto() {
		return eventDto;
	}

	public void setEventDto(EventDTO eventDto) {
		this.eventDto = eventDto;
	}

	public JoinInEntity convertToEntity() {
		final JoinInEntity joinInEntity = new JoinInEntity();
		joinInEntity.setId(id);
		joinInEntity.setAccept(accept);
		joinInEntity.setUserEmail(userEmail);
		joinInEntity.setCreatedOnDate(createdOnDate);
		joinInEntity.setEventEntity(eventDto.convertToEventEntity());
		return joinInEntity;
	}
	
	public static List<JoinInEntity> convertToListEntity(List<JoinInDTO> joinInDtos) {
		final List<JoinInEntity> joinInEntities = new ArrayList<JoinInEntity>();
		for(JoinInDTO joinInDTO : joinInDtos) {
			joinInEntities.add(joinInDTO.convertToEntity());
		}
		return joinInEntities;
	}
}
