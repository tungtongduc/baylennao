package de.txa.web;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.txa.dto.UserDTO;
import de.txa.dto.UserDTOtoCreate;
import de.txa.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/spring-conf.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", })
public class UserTest {

	@Inject
	public UserService userService;

	@Test
	public void saveUser() {
		UserDTOtoCreate xa = new UserDTOtoCreate("xuan anh", "xa@gmail.com",
				"baylennao");
		UserDTOtoCreate tony = new UserDTOtoCreate("tony",
				"tungtongduc@gmail.com", "tonytong");

		userService.create(xa);
		userService.create(tony);
	}

	@Test
	public void findByName() {
		UserDTO user = userService.findByName("xuan anh").get(0);
		assertEquals("Xuan Anh From DB and Real :", "xuan anh", user.getName());
	}

	@Test
	public void findByEmail() {
		UserDTO user = userService.findByEmail("tungtongduc@gmail.com");
		assertEquals("Tonys Email from DB and Real", "tungtongduc@gmail.com",
				user.getEmail());
	}

	@Test
	public void addFriend() {
		UserDTO user1 = userService.findByName("xuan anh").get(0);
		UserDTO user2 = userService.findByName("tony").get(0);

		userService.addFriend(user1.getId(), user2.getId());
	}
	
	@Test
	public void getAllFriend(){
		UserDTO user1 = userService.findByName("xuan anh").get(0);
		UserDTO tony = userService.getAllFriends(user1.getId()).get(0);
		assertEquals("Tony ist Friend of Xuan Anh", "tony", tony.getName());
	}

	@Test
	public void cleanDB() {
		UserDTO user1 = userService.findByName("xuan anh").get(0);
		UserDTO user2 = userService.findByName("tony").get(0);

		userService.delete(user1.getId());
		userService.delete(user2.getId());
	}
}
