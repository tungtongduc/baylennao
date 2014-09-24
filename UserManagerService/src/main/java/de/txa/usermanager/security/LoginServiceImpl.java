package de.txa.usermanager.security;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import de.txa.usermanager.entity.UserEntity;
import de.txa.usermanager.serviceimpl.BaseDAOImpl;

@Component
@Transactional("txUser")
public class LoginServiceImpl extends BaseDAOImpl<UserEntity> implements LoginService{
	
	private static final int FIST_ELEMENT = 0;
	private static final String SELECT = "SELECT u ";
	private static final String FROM_USERENTITY = "FROM UserEntity u ";
	private static final String WHERE_FILTER = "WHERE u.email=:email";

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity getUser(String email) {
		Query q = em.createQuery(SELECT + FROM_USERENTITY + WHERE_FILTER);
		q.setParameter("email", email);
		final List<UserEntity> result = q.getResultList();
		if (CollectionUtils.isEmpty(result)) {
			return null;
		}
		return result.get(FIST_ELEMENT);
	}

}
