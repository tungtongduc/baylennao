package de.txa.entity;

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
	
	private String u_Name;
	private String password;
	private Date birthday;
	private long telNr;
	private boolean gender;
	private String eMail;
	private UserRoll u_Roll;
	private String u_Icon;
	private String address;
	
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(name="user_group")
	private List<GroupEntity> groups;
	
	@OneToMany(mappedBy="groupAdmin")
	private List<GroupEntity> admin_Groups;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="friends", joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="friendId"))
	private List<UserEntity> isFriendOf = new ArrayList<UserEntity>();

	public String getU_Name() {
		return u_Name;
	}

	public void setU_Name(String u_Name) {
		this.u_Name = u_Name;
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

	public long getTelNr() {
		return telNr;
	}

	public void setTelNr(long telNr) {
		this.telNr = telNr;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public UserRoll getU_Roll() {
		return u_Roll;
	}

	public void setU_Roll(UserRoll u_Roll) {
		this.u_Roll = u_Roll;
	}

	public String getU_Icon() {
		return u_Icon;
	}

	public void setU_Icon(String u_Icon) {
		this.u_Icon = u_Icon;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
	public void addFriend(UserEntity u){
		this.isFriendOf.add(u);
	}
}
