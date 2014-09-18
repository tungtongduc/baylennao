package de.txa.usermanagerservice.security;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class LoginResultsetExtractor implements ResultSetExtractor<UserToLogin>{

	private static final String EMAIL = "eMail";
	private static final String PASSWORD = "password";
	private static final String USER_ROLLE = "u_Roll";

	public UserToLogin extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		final UserToLogin user = new UserToLogin();
		user.setEmail(rs.getString(EMAIL));
		user.setPassword(rs.getString(PASSWORD));
		user.setUserRoll((UserRoll) rs.getObject(USER_ROLLE));
		return user;
	}

}
