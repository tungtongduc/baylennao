package webTest.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String email;
	private long telephone;
	private int age;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_group")			  
	private List<Group> groups;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_poll")		
	private List<Poll> polls;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Zeitraum> zeitraums;
	
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
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
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Poll> getPolls() {
		return polls;
	}
	public void setPolls(List<Poll> polls) {
		this.polls = polls;
	}
	public List<Zeitraum> getZeitraums() {
		return zeitraums;
	}
	public void setZeitraums(List<Zeitraum> zeitraums) {
		this.zeitraums = zeitraums;
	}
	
}
