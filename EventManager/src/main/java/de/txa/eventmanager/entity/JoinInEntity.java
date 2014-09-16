package de.txa.eventmanager.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class JoinInEntity extends BaseEntity{
	private boolean accept;
	@OneToOne
	private UserEntity gast;
	
	public boolean isAccept() {
		return accept;
	}
	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	public UserEntity getGast() {
		return gast;
	}
	public void setGast(UserEntity gast) {
		this.gast = gast;
	}
	
}
