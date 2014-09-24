package de.txa.eventmanager.entity;

import javax.persistence.Entity;

@Entity
public class JoinInEntity extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private Boolean accept;
	private String userEmail;
	
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
}
