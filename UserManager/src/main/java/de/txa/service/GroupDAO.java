package de.txa.service;

import java.util.List;
import de.txa.entity.GroupEntity;

public interface GroupDAO extends BaseDAO <GroupEntity>{
	public List<GroupEntity> findGroupByName(String groupName);
	public GroupEntity findGroupById(long id);
}
