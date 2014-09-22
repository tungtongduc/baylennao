package de.txa.eventmanager.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CommentEntity extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private String commentContent;
	private Date commentDate;
	
	@OneToOne
	private UserEntity commentAutor;

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public UserEntity getCommentAutor() {
		return commentAutor;
	}

	public void setCommentAutor(UserEntity commentAutor) {
		this.commentAutor = commentAutor;
	}
}
