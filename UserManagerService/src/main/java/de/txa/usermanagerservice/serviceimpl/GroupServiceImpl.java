package de.txa.usermanagerservice.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.txa.usermanagerservice.dto.Convert;
import de.txa.usermanagerservice.dto.GroupDTO;
import de.txa.usermanagerservice.entity.GroupEntity;
import de.txa.usermanagerservice.service.GroupDAO;
import de.txa.usermanagerservice.service.GroupService;

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
	public List<GroupDTO> findByName(String groupName) {
		return Convert.convertToListGroupDTO(groupDao.findGroupByName(groupName));
	}

	@Override
	public GroupDTO findById(long id) {
		return Convert.convertToGroupDTO(groupDao.findById(id, GroupEntity.class));
	}

}
