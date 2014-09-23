package de.txa.eventmanager.entity;

import javax.persistence.Entity;

@Entity
public class JoinInEntity extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private boolean accept;
	private String userEmail;
	
	public boolean isAccept() {
		return accept;
	}
	
	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
