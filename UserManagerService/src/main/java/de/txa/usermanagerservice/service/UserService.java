package de.txa.usermanagerservice.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import de.txa.usermanagerservice.dto.UserDTO;
import de.txa.usermanagerservice.jdbctemplate.UserRowMapper;

public class UserService extends ServiceFactory{

	private static final String SELECT_MAPPED = "SELECT id,"
			+ "address,"
			+ "u_Icon,"
			+ "birthday,"
			+ "eMail,"
			+ "u_Name,"
			+ "telNr,"
			+ "createdOnDate,"
			+ "updatedOnDate,"
			+ "gender ";
	private static final String FROM_DATABASE_TABLE = "FROM UserEntity ";
	private static final String WHERE_FILTER_EMAIL = "WHERE eMail = ?";

	public List<UserDTO> findUserByEmail(String email) {
		final JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query(SELECT_MAPPED + FROM_DATABASE_TABLE + WHERE_FILTER_EMAIL, 
						new Object[] { email },
		                new UserRowMapper());
	}

}
