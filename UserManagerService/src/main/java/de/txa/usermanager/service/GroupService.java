package de.txa.usermanager.service;

import java.util.List;

import de.txa.usermanager.dto.GroupDTO;

public interface GroupService {
	public void create(GroupDTO groupDTO);
	public void delete(long id);
	public void update(GroupDTO groupDTO);
	public List<GroupDTO> findGroupByName(String groupName);
	public GroupDTO findById(long id);
}
