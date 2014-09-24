package de.txa.usermanager.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.txa.usermanager.dto.ConvertToDTO;
import de.txa.usermanager.dto.UserDTO;
import de.txa.usermanager.dto.UserDTOtoCreate;
import de.txa.usermanager.entity.UserEntity;
import de.txa.usermanager.service.UserDAO;
import de.txa.usermanager.service.UserService;

@Component
@Transactional("txUser")
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO userDao;
	
	@Override
	public void create(UserDTOtoCreate newUser) {
		userDao.create(setUpdateDateForEntity(newUser.convertToUserEntity()));
	}

	//TODO
	@Override
	public void update(UserDTO newUser) {
		if(newUser.getId() != null) {
			final UserEntity oldUser = userDao.findById(newUser.getId(), UserEntity.class);
			if(oldUser != null) {
				userDao.update(setUpdateDateForEntity(newUser.convertToUserEntity(oldUser)));
			}
		}
	}

	@Override
	public void delete(long userID) {
		userDao.delete(userID, UserEntity.class);
	}

	@Override
	public List<UserDTO> findByName(String userName) {
		return ConvertToDTO.convertToListUserDTO(userDao.findByName(userName));
	}

	@Override
	public UserDTO findById(long id) {
		return ConvertToDTO.convertToUserDTO(userDao.findById(id, UserEntity.class));
	}

	@Override
	public UserDTO findByEmail(String email) {
		return ConvertToDTO.convertToUserDTO(userDao.findByEmail(email));
	}

	@Override
	public List<UserDTO> getAllUser() {
		return ConvertToDTO.convertToListUserDTO(userDao.getAllUsers());
	}

	@Override
	public List<UserDTO> getUserByQuery(String query) {
		return ConvertToDTO.convertToListUserDTO(userDao.getUserByQuery(query));
	}

	@Override
	public List<UserDTO> getAllFriends(long idFromUser) {
		return ConvertToDTO.convertToListUserDTO(userDao.getAllFriends(idFromUser));
	}

	@Override
	public void addFriend(long idFromUser, long idFromFriend) {
		userDao.addFriend(idFromUser, idFromFriend);
	}

	private UserEntity setUpdateDateForEntity(UserEntity userEntity) {
		userEntity.setUpdatedOnDate(new Date());
		return userEntity;
	}

	@Override
	public boolean checkPassswordBeforeChange(String password, String email) {
		final UserEntity user = userDao.findByEmail(email);
		if(user != null) {
			final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(passwordEncoder.matches(password, user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void changePassword(String password, String email) {
		final UserEntity user = userDao.findByEmail(email);
		final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(password));
		userDao.update(setUpdateDateForEntity(user));
	}
}
