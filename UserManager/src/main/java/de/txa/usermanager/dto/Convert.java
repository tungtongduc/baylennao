package de.txa.usermanager.dto;

import java.util.ArrayList;
import java.util.List;

import de.txa.usermanager.entity.GroupEntity;
import de.txa.usermanager.entity.UserEntity;

public class Convert {
	
	public static UserDTO convertToUserDTO(UserEntity userentity){
		final UserDTO userDTO = new UserDTO(userentity.getU_Name(), userentity.geteMail(), userentity.getTelNr(), userentity.getAddress(), userentity.getBirthday(), userentity.getU_Icon());
		userDTO.setId(userentity.getId());
		return userDTO;
	}
	
	public static List<UserDTO> convertToListUserDTO(List<UserEntity> userlist){
		List<UserDTO> users = new ArrayList<UserDTO>();
		
		for(UserEntity u : userlist){
			users.add(convertToUserDTO(u));
		}
		
		return users;
	}
	
	public static UserEntity convertToUserEntity(UserDTOtoCreate u){
		final UserEntity userentity = new UserEntity();
		userentity.setU_Name(u.getName());
		userentity.seteMail(u.getEmail());
		userentity.setPassword(u.getPassword());
		return userentity;
	}
	
	public static GroupEntity convertToGroupEntity(GroupDTO group){
		final GroupEntity groupEntity = new GroupEntity();
		groupEntity.setGroupName(group.getGroup_name());
		groupEntity.setDescription(group.getDescription());
		return groupEntity;
	}
	
	public static GroupDTO convertToGroupDTO(GroupEntity groupentity){
		final GroupDTO groupDto = new GroupDTO(groupentity.getGroupName(), groupentity.getDescription());
		groupDto.setId(groupentity.getId());
		return groupDto;
	}
	
	public static List<GroupDTO> convertToListGroupDTO(List<GroupEntity> grouplist){
		List<GroupDTO> groups = new ArrayList<GroupDTO>();
		
		for(GroupEntity g : grouplist){
			groups.add(Convert.convertToGroupDTO(g));
		}
		
		return groups;
	}
}
