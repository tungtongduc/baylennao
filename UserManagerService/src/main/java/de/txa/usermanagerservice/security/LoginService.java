package de.txa.usermanagerservice.security;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;

import de.txa.usermanagerservice.service.ServiceFactory;


public class LoginService extends ServiceFactory{

	private static final String SELECT_MAPPED = "SELECT "
			+ "eMail,"
			+ "u_Roll,"
			+ "password ";
	private static final String FROM_DATABASE_TABLE = "FROM UserEntity ";
	private static final String WHERE_FILTER_EMAIL = "WHERE eMail = ?";

	public UserToLogin getUser(String username, String password) {
		return null;
	}

	public UserToLogin getUser(String email) {
		final JdbcTemplate select = new JdbcTemplate(dataSource);
		final List<UserToLogin> users = select.query(SELECT_MAPPED + FROM_DATABASE_TABLE + WHERE_FILTER_EMAIL, 
				new Object[] { email },
                new LoginRowMapper());
		if(CollectionUtils.isEmpty(users)) {
			return null;
		}
		return users.get(0);
	}
}
