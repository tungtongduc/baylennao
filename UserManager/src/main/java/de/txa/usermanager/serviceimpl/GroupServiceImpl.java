package de.txa.usermanager.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.txa.usermanager.dto.Convert;
import de.txa.usermanager.dto.GroupDTO;
import de.txa.usermanager.entity.GroupEntity;
import de.txa.usermanager.service.GroupDAO;
import de.txa.usermanager.service.GroupService;

@Component
@Transactional
public class GroupServiceImpl implements GroupService{
	
	@Inject
	private GroupDAO groupDao;

	@Override
	public void create(GroupDTO groupDTO) {
		groupDao.create(Convert.convertToGroupEntity(groupDTO));
	}

	@Override
	public void delete(long id) {
		groupDao.delete(id, GroupEntity.class);
	}

	@Override
	public void update(GroupDTO groupDTO) {
		groupDao.update(Convert.convertToGroupEntity(groupDTO));
	}

	@Override
	public List<GroupDTO> findGroupByName(String groupName) {
		return Convert.convertToListGroupDTO(groupDao.findGroupByName(groupName));
	}

	@Override
	public GroupDTO findById(long id) {
		return Convert.convertToGroupDTO(groupDao.findById(id, GroupEntity.class));
	}

}
