//package de.txa.eventmanager.entity;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//@Entity
//public class UserEntity extends BaseEntity{
//	
//	private static final long serialVersionUID = 1L;
//
//	private String email;
//	
//	@OneToMany(mappedBy="host", fetch=FetchType.LAZY) 
//	private List<EventEntity> events;
//	
//	@OneToOne(mappedBy="commentAutor", fetch=FetchType.LAZY)
//	private CommentEntity comment;
//	
//	@OneToOne(mappedBy="gast", fetch=FetchType.LAZY)
//	private JoinInEntity joinIn;
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public List<EventEntity> getEvents() {
//		return events;
//	}
//
//	public void setEvents(List<EventEntity> events) {
//		this.events = events;
//	}
//
//	public CommentEntity getComment() {
//		return comment;
//	}
//
//	public void setComment(CommentEntity comment) {
//		this.comment = comment;
//	}
//
//	public JoinInEntity getJoinIn() {
//		return joinIn;
//	}
//
//	public void setJoinIn(JoinInEntity joinIn) {
//		this.joinIn = joinIn;
//	}
//}
