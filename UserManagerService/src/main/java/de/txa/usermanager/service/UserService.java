package de.txa.usermanager.service;

import java.util.List;

import de.txa.usermanager.dto.UserDTO;
import de.txa.usermanager.dto.UserDTOtoCreate;

public interface UserService {
	
	public void create(UserDTOtoCreate newUser);
	public void update(UserDTO newUser);
	public void delete(long userID);
	public List<UserDTO> findByName(String userName);
	public UserDTO findById(long id);
	public UserDTO findByEmail(String email);
	public List<UserDTO> getAllUser();
	public List<UserDTO> getUserByQuery(String query);
	public List<UserDTO> getAllFriends(long idFromUser);
	public void addFriend(long idFromUser, long idFromFriend);
	public boolean checkPassswordBeforeChange(String password, String email);
}
