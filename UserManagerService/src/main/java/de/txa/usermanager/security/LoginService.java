package de.txa.usermanager.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;

import de.txa.usermanager.entity.UserEntity;

public class LoginService{
	
	private static final int FIST_ELEMENT = 0;
	private static final String SELECT = "SELECT u ";
	private static final String FROM_USERENTITY = "FROM UserEntity u ";
	private static final String WHERE_FILTER = "WHERE u.email=:email";
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("userManager");
	private final EntityManager em;
	
	public LoginService() {
		this.em = emf.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	public UserEntity getUser(String email) {
		Query q = em.createQuery(SELECT + FROM_USERENTITY + WHERE_FILTER);
		q.setParameter("email", email);
		final List<UserEntity> result = q.getResultList();
		UserEntity user = null;
		if (!CollectionUtils.isEmpty(result)) {
			user = result.get(FIST_ELEMENT);
		}
		em.close();
		return user;
	}

}
