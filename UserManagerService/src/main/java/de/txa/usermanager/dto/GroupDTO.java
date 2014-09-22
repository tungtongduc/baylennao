package de.txa.usermanager.dto;

import de.txa.usermanager.entity.GroupEntity;

public class GroupDTO {
	public Long id;
	public String group_name;
	public String description;
	public UserDTO host;
	
	public GroupDTO(String group_name, String description) {
		super();
		this.group_name = group_name;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserDTO getHost() {
		return host;
	}

	public void setHost(UserDTO host) {
		this.host = host;
	}
	
	public GroupEntity convertToGroupEntity(GroupEntity groupEntity) {
		if(groupEntity == null) {
			groupEntity = new GroupEntity();
		}
		groupEntity.setId(id);
		groupEntity.setGroupName(group_name);
		groupEntity.setDescription(description);
		return groupEntity;
	}

}
