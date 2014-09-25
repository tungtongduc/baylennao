package de.txa.eventmanager.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class JoinInEntity extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private Boolean accept;
	private String userEmail;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private EventEntity eventEntity;
	
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

	public EventEntity getEventEntity() {
		return eventEntity;
	}

	public void setEventEntity(EventEntity eventEntity) {
		this.eventEntity = eventEntity;
	}
}
