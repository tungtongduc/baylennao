package de.txa.eventmanager.dto;

import java.util.Date;

public class EventDTO {
	
	private Long id;
	private String eventName;
	private String eventContent;
	private Date eventDate;
	private String eventLocation;
	private String eventIcon;
	private String hostEmail;

	public EventDTO(String eventName, String eventContent, Date eventDate,
			String eventLocation, String eventIcon) {
		super();
		this.eventName = eventName;
		this.eventContent = eventContent;
		this.eventDate = eventDate;
		this.eventLocation = eventLocation;
		this.eventIcon = eventIcon;
	}
	
	public EventDTO(String eventName, String eventContent, String eventLocation){
		super();
		this.eventName = eventName;
		this.eventContent = eventContent;
		this.eventLocation = eventLocation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventIcon() {
		return eventIcon;
	}

	public void setEventIcon(String eventIcon) {
		this.eventIcon = eventIcon;
	}

	public String getHostEmail() {
		return hostEmail;
	}

	public void setHostEmail(String hostEmail) {
		this.hostEmail = hostEmail;
	}
	
}
