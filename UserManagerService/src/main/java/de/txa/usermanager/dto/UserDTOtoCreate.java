package de.txa.usermanager.dto;

import javax.validation.constraints.NotNull;

import de.txa.usermanager.entity.UserEntity;

public class UserDTOtoCreate {

	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String password;

	public UserDTOtoCreate(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserDTOtoCreate() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserEntity convertToUserEntity() {
		final UserEntity userentity = new UserEntity();
		userentity.setUsername(name);
		userentity.setEmail(email);
		userentity.setPassword(password);
		return userentity;
	}
}