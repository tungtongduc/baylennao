package de.txa.usermanager.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.txa.usermanager.dto.ConvertToDTO;
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
		groupDao.create(setUpdateDateForEntity(groupDTO.convertToGroupEntity(null)));
	}

	@Override
	public void delete(long id) {
		groupDao.delete(id, GroupEntity.class);
	}

	@Override
	public void update(GroupDTO newGroup) {
		if(newGroup.getId() != null) {
			final GroupEntity oldGroup = groupDao.findById(newGroup.getId(), GroupEntity.class);
			groupDao.update(setUpdateDateForEntity(newGroup.convertToGroupEntity(oldGroup)));
		}
	}

	@Override
	public List<GroupDTO> findGroupByName(String groupName) {
		return ConvertToDTO.convertToListGroupDTO(groupDao.findGroupByName(groupName));
	}

	@Override
	public GroupDTO findById(long id) {
		return ConvertToDTO.convertToGroupDTO(groupDao.findById(id, GroupEntity.class));
	}

	private GroupEntity setUpdateDateForEntity(GroupEntity groupEntity) {
		groupEntity.setUpdatedOnDate(new Date());
		return groupEntity;
	}
}
