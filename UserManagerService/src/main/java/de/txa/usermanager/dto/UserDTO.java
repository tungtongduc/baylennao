package de.txa.usermanager.dto;

import java.util.Date;

import de.txa.usermanager.entity.UserEntity;

public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private Long phone;
	private String address;
	private Date birthday;
	private String avatar;
	private Boolean gender;
	private Date createdOnDate;
	private Date updatedOnDate;
	
	public UserDTO() {

	}

	public UserDTO(String name, String email, long phone, String address,
			Date birthday, String avatar, boolean gender, Date createdOnDate,
			Date updatedOnDate) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		this.avatar = avatar;
		this.gender = gender;
		this.createdOnDate = createdOnDate;
		this.updatedOnDate = updatedOnDate;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getCreatedOnDate() {
		return createdOnDate;
	}

	public void setCreatedOnDate(Date createdOnDate) {
		this.createdOnDate = createdOnDate;
	}

	public Date getUpdatedOnDate() {
		return updatedOnDate;
	}

	public void setUpdatedOnDate(Date updatedOnDate) {
		this.updatedOnDate = updatedOnDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public UserEntity convertToUserEntity(UserEntity user) {
		if(user == null) {
			user = new UserEntity();
		}
		user.setId(id);
		user.setUsername(name);
		user.setEmail(email);
		user.setTelNr(phone);
		user.setAdress(address);
		user.setBirthday(birthday);
		user.setUserIcon(avatar);
		user.setGender(gender);
		return user;
	}
}
