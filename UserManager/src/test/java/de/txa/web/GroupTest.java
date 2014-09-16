package de.txa.web;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.txa.usermanager.dto.GroupDTO;
import de.txa.usermanager.dto.UserDTO;
import de.txa.usermanager.service.GroupService;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/spring-conf.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", })
public class GroupTest {

	@Inject
	public GroupService gs;
	
	@Test
	public void create(){
		GroupDTO group = new GroupDTO("Bay len nao","event bay thu 7 hang tuan");
		UserDTO host = new  UserDTO();
		host.setName("long");
		group.setHost(host);
		gs.create(group);
	}
	
	@Test
	public void findById(){
		GroupDTO group = gs.findGroupByName("Bay len nao").get(0);
		GroupDTO groupFound = gs.findById(group.getId());
		
		assertEquals("Group From DB and Real", group.getGroup_name(), groupFound.getGroup_name());
	}
	
	@Test
	public void delete(){
		GroupDTO group = gs.findGroupByName("Bay len nao").get(0);
		gs.delete(group.getId());
	}
}
