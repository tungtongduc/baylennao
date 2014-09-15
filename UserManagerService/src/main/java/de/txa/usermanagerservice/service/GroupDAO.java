package de.txa.usermanagerservice.service;

import java.util.List;

import de.txa.usermanagerservice.entity.GroupEntity;
import de.txa.usermanagerservice.entity.UserEntity;

public interface GroupDAO extends BaseDAO <GroupEntity>{
	public List<GroupEntity> findGroupByName(String groupName);
	public GroupEntity findGroupById(long id);
	public List<UserEntity> findAllUserFromGroup();
}
