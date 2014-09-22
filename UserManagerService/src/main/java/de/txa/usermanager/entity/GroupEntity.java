package de.txa.usermanager.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class GroupEntity extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String groupName;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private UserEntity groupAdmin;

	@ManyToMany(fetch=FetchType.LAZY, mappedBy="groups")
	private List<UserEntity> users;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserEntity getGroupAdmin() {
		return groupAdmin;
	}

	public void setGroupAdmin(UserEntity groupAdmin) {
		this.groupAdmin = groupAdmin;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
}
