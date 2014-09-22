package de.txa.usermanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class UserEntity extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private Date birthday;
	private Long telNr;
	private Boolean gender;
	private String email;
	private UserRoll userRolle;
	private String userIcon;
	private String adress;
	
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(name="user_group")
	private List<GroupEntity> groups;
	
	@OneToMany(mappedBy="groupAdmin")
	private List<GroupEntity> admin_Groups;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="friends", joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="friendId"))
	private List<UserEntity> isFriendOf;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getTelNr() {
		return telNr;
	}

	public void setTelNr(Long telNr) {
		this.telNr = telNr;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRoll getUserRolle() {
		return userRolle;
	}

	public void setUserRolle(UserRoll userRolle) {
		this.userRolle = userRolle;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public List<GroupEntity> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupEntity> groups) {
		this.groups = groups;
	}

	public List<GroupEntity> getAdmin_Groups() {
		return admin_Groups;
	}

	public void setAdmin_Groups(List<GroupEntity> admin_Groups) {
		this.admin_Groups = admin_Groups;
	}

	public List<UserEntity> getIsFriendOf() {
		return isFriendOf;
	}

	public void setIsFriendOf(List<UserEntity> isFriendOf) {
		this.isFriendOf = isFriendOf;
	}

	public void addFriend(UserEntity friend) {
		if(isFriendOf == null) {
			isFriendOf = new ArrayList<UserEntity>();
		}
		isFriendOf.add(friend);
	}
}
