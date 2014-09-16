package de.txa.usermanagerservice.service;

import java.util.List;

import de.txa.usermanagerservice.dto.GroupDTO;

public interface GroupService {
	public void create(GroupDTO groupDTO);
	public void delete(long id);
	public void update(GroupDTO groupDTO);
	public List<GroupDTO> findByName(String groupName);
	public GroupDTO findById(long id);
}
