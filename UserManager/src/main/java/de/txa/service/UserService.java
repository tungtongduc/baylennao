package de.txa.service;

import java.util.List;

import javax.persistence.Query;

import de.txa.dto.UserDTO;
import de.txa.dto.UserDTOtoCreate;

public interface UserService {
	
	public void create(UserDTOtoCreate newUser);
	public void update(UserDTO oldUser);
	public void delete(long userID);
	public List<UserDTO> findByName(String userName);
	public UserDTO findById(long id);
	public UserDTO findByEmail(String email);
	public List<UserDTO> getAllUser();
	public List<UserDTO> getUserByQuery(Query query);
	public List<UserDTO> getAllFriends(long idFromUser);
	public void addFriend(long idFromUser, long idFromFriend);
	
}
