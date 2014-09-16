package de.txa.usermanagerservice.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import de.txa.usermanagerservice.dto.UserDTO;
import de.txa.usermanagerservice.jdbctemplate.UserRowMapper;

public class UserService {

	private static final String SELECT_MAPPED = "SELECT * ";
	private static final String FROM_DATABASE_TABLE = "FROM UserEntity ";
	private static final String WHERE_FILTER_EMAIL = "WHERE eMail = ?";
	private DataSource dataSource;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	public List<UserDTO> findUserByEmail(String email) {
		final JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query(SELECT_MAPPED + FROM_DATABASE_TABLE + WHERE_FILTER_EMAIL, 
						new Object[] { email },
		                new UserRowMapper());
	}

}
