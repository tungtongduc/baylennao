package de.txa.usermanagerservice.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import de.txa.usermanagerservice.dto.UserDTO;

public class UserResultSetExtractor implements ResultSetExtractor<UserDTO>{

	private static final String ID = "id";
	private static final String ADRESS = "address";
	private static final String AVATA = "u_Icon";
	private static final String BIRTHDAY = "birthday";
	private static final String EMAIL = "eMail";
	private static final String USERNAME = "u_Name";
	private static final String TELEPHONE = "telNr";
	private static final String CREATEDDATE = "createdOnDate";
	private static final String UPDATEDATE = "updatedOnDate";
	private static final String GENDER = "gender";

	public UserDTO extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		final UserDTO userDTO = new UserDTO();
		userDTO.setId(rs.getLong(ID));
		userDTO.setAddress(rs.getString(ADRESS));
		userDTO.setAvatar(rs.getString(AVATA));
		userDTO.setBirthday(rs.getDate(BIRTHDAY));
		userDTO.setEmail(rs.getString(EMAIL));
		userDTO.setName(rs.getString(USERNAME));
		userDTO.setPhone(rs.getLong(TELEPHONE));
		userDTO.setCreatedOnDate(rs.getDate(CREATEDDATE));
		userDTO.setUpdatedOnDate(rs.getDate(UPDATEDATE));
		userDTO.setGender(rs.getBoolean(GENDER));
		return userDTO;
	}

}
