package de.txa.service;

import java.util.List;

import de.txa.entity.UserEntity;

public interface UserDAO extends BaseDAO<UserEntity>{
	
	public List<UserEntity> findByName(String userName);
	public UserEntity findByEmail(String email);
	public List<UserEntity> getAllUsers();
	public List<UserEntity> getUserByQuery(String query);
	public void addFriend(long idFromUser, long idFromFriend);
	public List<UserEntity> getAllFriends(long idFromUser);
	public UserEntity findByEmailAndPassword(String email, String password);
}
