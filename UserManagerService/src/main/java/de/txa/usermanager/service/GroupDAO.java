package de.txa.usermanager.service;

import java.util.List;

import de.txa.usermanager.entity.GroupEntity;
import de.txa.usermanager.entity.UserEntity;

public interface GroupDAO extends BaseDAO <GroupEntity>{
	public List<GroupEntity> findGroupByName(String groupName);
	public GroupEntity findGroupById(long id);
	public List<UserEntity> findAllUserFromGroup();
}
