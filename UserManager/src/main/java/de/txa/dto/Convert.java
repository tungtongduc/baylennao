package de.txa.dto;

import java.util.ArrayList;
import java.util.List;

import de.txa.entity.UserEntity;

public class Convert {
	
	public static UserDTO convertToDTO(UserEntity userentity){
		final UserDTO userDTO = new UserDTO(userentity.getU_Name(), userentity.geteMail(), userentity.getTelNr(), userentity.getAddress(), userentity.getBirthday(), userentity.getU_Icon());
		userDTO.setId(userentity.getId());
		return userDTO;
	}
	
	public static List<UserDTO> convertListToListDTO(List<UserEntity> userlist){
		List<UserDTO> users = new ArrayList<UserDTO>();
		
		for(UserEntity u : userlist){
			users.add(convertToDTO(u));
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
}
