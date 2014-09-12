package de.txa.security;

import javax.inject.Inject;

import de.txa.entity.UserEntity;
import de.txa.service.UserDAO;

public class LoginService {
	
	@Inject
	private UserDAO userDao;
	
	public UserEntity getUser(String username, String password) {
		return userDao.findByEmailAndPassword(username, password);
	}
	
	public UserEntity getUser(String email) {
		return userDao.findByEmail(email);
	}
}
