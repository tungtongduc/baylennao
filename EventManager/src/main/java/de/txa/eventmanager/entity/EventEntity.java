package de.txa.eventmanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class EventEntity extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private String eventName;
	private String eventContent;
	private Date eventDate;
	private String eventLocation;
	private String eventIcon;
	private String hostEmail;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "eventEntity")
	private List<JoinInEntity> invites;

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
	
	public List<JoinInEntity> getInvites() {
		return invites;
	}

	public void setInvites(List<JoinInEntity> invites) {
		this.invites = invites;
	}

	public void addJoinIn(JoinInEntity joinInEntity) {
		if(invites == null) {
			invites = new ArrayList<JoinInEntity>();
		}
		invites.add(joinInEntity);
	}
}
