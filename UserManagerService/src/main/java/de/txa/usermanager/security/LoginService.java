package de.txa.usermanager.security;

import de.txa.usermanager.entity.UserEntity;

public interface LoginService {

	public UserEntity getUser(String email);
}
