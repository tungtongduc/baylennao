package de.txa.eventmanager.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class UserEntity extends BaseEntity{
	private String email;
	
	@OneToOne(mappedBy="host", fetch=FetchType.LAZY) 
	private EventEntity event;
	
	@OneToOne(mappedBy="commentAutor", fetch=FetchType.LAZY)
	private CommentEntity comment;
	
	@OneToOne(mappedBy="gast", fetch=FetchType.LAZY)
	private JoinInEntity joinIn;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}

	public CommentEntity getComment() {
		return comment;
	}

	public void setComment(CommentEntity comment) {
		this.comment = comment;
	}

	public JoinInEntity getJoinIn() {
		return joinIn;
	}

	public void setJoinIn(JoinInEntity joinIn) {
		this.joinIn = joinIn;
	}
}
