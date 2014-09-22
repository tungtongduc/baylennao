package de.txa.eventmanager.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class EventEntity extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private String eventName;
	private String eventContent;
	private Date eventDate;
	private String eventLocation;
	private String eventIcon;
	
	@OneToOne
	private UserEntity host;

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

	public UserEntity getHost() {
		return host;
	}

	public void setHost(UserEntity host) {
		this.host = host;
	}
}
