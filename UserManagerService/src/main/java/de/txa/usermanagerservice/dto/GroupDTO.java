package de.txa.usermanagerservice.dto;

public class GroupDTO {
	public Long id;

	public String group_name;
	public String description;
	
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
}
