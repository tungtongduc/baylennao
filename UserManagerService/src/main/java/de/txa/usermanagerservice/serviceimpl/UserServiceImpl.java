package de.txa.usermanagerservice.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.txa.usermanagerservice.dto.Convert;
import de.txa.usermanagerservice.dto.UserDTO;
import de.txa.usermanagerservice.dto.UserDTOtoCreate;
import de.txa.usermanagerservice.entity.UserEntity;
import de.txa.usermanagerservice.service.UserDAO;
import de.txa.usermanagerservice.service.UserService;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO userDao;
	
	@Override
	public void create(UserDTOtoCreate newUser) {
		userDao.create(Convert.convertToUserEntity(newUser));
	}

	//TODO
	@Override
	public void update(UserDTO oldUser) {
//		userDao.update(Convert.convertToUserEntity(oldUser));
		
	}

	@Override
	public void delete(long userID) {
		userDao.delete(userID, UserEntity.class);
	}

	@Override
	public List<UserDTO> findByName(String userName) {
		return Convert.convertToListUserDTO(userDao.findByName(userName));
	}

	@Override
	public UserDTO findById(long id) {
		return Convert.convertToUserDTO(userDao.findById(id, UserEntity.class));
	}

	@Override
	public UserDTO findByEmail(String email) {
		return Convert.convertToUserDTO(userDao.findByEmail(email));
	}

	@Override
	public List<UserDTO> getAllUser() {
		return Convert.convertToListUserDTO(userDao.getAllUsers());
	}

	@Override
	public List<UserDTO> getUserByQuery(Query query) {
		return null;
	}

	@Override
	public List<UserDTO> getAllFriends(long idFromUser) {
		return Convert.convertToListUserDTO(userDao.getAllFriends(idFromUser));
	}

	@Override
	public void addFriend(long idFromUser, long idFromFriend) {
		userDao.addFriend(idFromUser, idFromFriend);
	}

}
