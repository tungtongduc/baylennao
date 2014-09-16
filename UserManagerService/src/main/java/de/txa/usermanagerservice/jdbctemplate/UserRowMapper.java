package de.txa.usermanagerservice.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import de.txa.usermanagerservice.dto.UserDTO;


public class UserRowMapper implements RowMapper<UserDTO>{

	public UserDTO mapRow(ResultSet arg0, int arg1) throws SQLException {
		UserResultSetExtractor extractor = new UserResultSetExtractor();
		return extractor.extractData(arg0);
	}
	
}
