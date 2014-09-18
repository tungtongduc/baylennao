package de.txa.usermanagerservice.security;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginRowMapper implements RowMapper<UserToLogin>{

	public UserToLogin mapRow(ResultSet arg0, int arg1) throws SQLException {
		LoginResultsetExtractor extractor = new LoginResultsetExtractor();
		return extractor.extractData(arg0);
	}

}
