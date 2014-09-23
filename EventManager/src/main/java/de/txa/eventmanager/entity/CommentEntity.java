package de.txa.eventmanager.entity;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class CommentEntity extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private String commentContent;
	private Date commentDate;
	private String userEmail;

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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
