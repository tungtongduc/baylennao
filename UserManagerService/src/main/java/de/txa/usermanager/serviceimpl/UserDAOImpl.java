package de.txa.usermanager.serviceimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import de.txa.usermanager.entity.UserEntity;
import de.txa.usermanager.service.UserDAO;

@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class UserDAOImpl extends BaseDAOImpl<UserEntity> implements UserDAO {

	private static final String SELECT = "SELECT u ";
	private static final String FROM_USERENTITY = "FROM UserEntity u ";
	private static final String WHERE = "WHERE ";
	private static final String AND = "AND ";
	private static final String FILTER_BY_USERNAME = "u.username=:userName ";
	private static final String FILTER_BY_EMAIL = "u.email=:email ";
	private static final String FILTER_BY_PASSWORD = "u.password=:password ";

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> findByName(String userName) {
		Query q = em
				.createQuery(SELECT + FROM_USERENTITY + WHERE + FILTER_BY_USERNAME);
		q.setParameter("userName", userName);
		return (List<UserEntity>) q.getResultList();
	}

	@Override
	public UserEntity findByEmail(String email) {
		Query q = em
				.createQuery(SELECT + FROM_USERENTITY + WHERE + FILTER_BY_EMAIL);
		q.setParameter("email", email);
		System.out.println(email);
		return checkNullException(q);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getAllUsers() {
		Query query = em.createQuery(SELECT + FROM_USERENTITY );
		return (List<UserEntity>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUserByQuery(String query) {
		Query q = em.createNativeQuery(query);
		return (List<UserEntity>) q.getResultList();
	}

	@Override
	public UserEntity findByEmailAndPassword(String email, String password) {
		Query q = em
				.createQuery(SELECT + FROM_USERENTITY + WHERE + FILTER_BY_EMAIL + AND + FILTER_BY_PASSWORD);
		q.setParameter("email", email);
		q.setParameter("password", password);
		
		return checkNullException(q);
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
	
	@SuppressWarnings("unchecked")
	private UserEntity checkNullException(Query q){
		final List<UserEntity> ul = q.getResultList();
		if (CollectionUtils.isEmpty(ul)) {
			return null;
		} else
			return ul.get(0);
	}
}
