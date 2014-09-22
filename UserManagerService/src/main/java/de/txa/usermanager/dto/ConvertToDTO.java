package de.txa.usermanager.dto;

import java.util.ArrayList;
import java.util.List;

import de.txa.usermanager.entity.GroupEntity;
import de.txa.usermanager.entity.UserEntity;

public class ConvertToDTO {

	public static UserDTO convertToUserDTO(UserEntity userentity) {
		final UserDTO userDTO = new UserDTO(
								userentity.getUsername(),
								userentity.getEmail(), 
								userentity.getTelNr(),
								userentity.getAdress(), 
								userentity.getBirthday(),
								userentity.getUserIcon(), 
								userentity.getGender(),
								userentity.getCreatedOnDate(), 
								userentity.getUpdatedOnDate());
		userDTO.setId(userentity.getId());
		return userDTO;
	}

	public static List<UserDTO> convertToListUserDTO(List<UserEntity> userlist) {
		List<UserDTO> users = new ArrayList<UserDTO>();

		for (UserEntity u : userlist) {
			users.add(convertToUserDTO(u));
		}

		return users;
	}

	public static GroupDTO convertToGroupDTO(GroupEntity groupentity) {
		final GroupDTO groupDto = new GroupDTO(
				groupentity.getGroupName(),
				groupentity.getDescription());
		groupDto.setId(groupentity.getId());
		return groupDto;
	}

	public static List<GroupDTO> convertToListGroupDTO(
			List<GroupEntity> grouplist) {
		List<GroupDTO> groups = new ArrayList<GroupDTO>();

		for (GroupEntity g : grouplist) {
			groups.add(ConvertToDTO.convertToGroupDTO(g));
		}

		return groups;
	}
}
