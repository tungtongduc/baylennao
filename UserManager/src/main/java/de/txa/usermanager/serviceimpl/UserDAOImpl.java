package de.txa.usermanager.serviceimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import de.txa.usermanager.entity.UserEntity;
import de.txa.usermanager.service.UserDAO;

@Component
public class UserDAOImpl extends BaseDAOImpl<UserEntity> implements UserDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> findByName(String userName) {
		Query q = em
				.createQuery("SELECT u FROM UserEntity u WHERE u.u_Name=:userName");
		q.setParameter("userName", userName);
		return (List<UserEntity>) q.getResultList();
	}

	@Override
	public UserEntity findByEmail(String email) {
		Query q = em
				.createQuery("SELECT u FROM UserEntity u WHERE u.eMail=:email");
		q.setParameter("email", email);
		System.out.println(email);
		return checkNullException(q);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getAllUsers() {
		Query query = em.createQuery("SELECT u FROM UserEntity u");
		return (List<UserEntity>) query.getResultList();
	}

	@Override
	public List<UserEntity> getUserByQuery(String query) {
		return null;
	}

	@Override
	public UserEntity findByEmailAndPassword(String email, String password) {
		Query q = em
				.createQuery("SELECT u FROM UserEntity u WHERE u.eMail=:email AND u.password=:password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		
		return checkNullException(q);
	}

	@SuppressWarnings("unchecked")
	private UserEntity checkNullException(Query q){
		final List<UserEntity> ul = q.getResultList();
		if (CollectionUtils.isEmpty(ul)) {
			return null;
		} else
			return ul.get(0);
	}

	@Override
	public List<UserEntity> getAllFriends(long idFromUser) {
		UserEntity u = this.findById(idFromUser, UserEntity.class);
		if(u != null){
			return u.getIsFriendOf();
		}else
		return null;
	}

	@Override
	public void addFriend(long idFromUser, long idFromFriend) {
		UserEntity u1 = this.findById(idFromUser, UserEntity.class);
		UserEntity u2 = this.findById(idFromFriend, UserEntity.class);
		
		if((u1 != null) && (u2 != null)){
			u1.addFriend(u2);
			em.merge(u1);
		}
	}
}
