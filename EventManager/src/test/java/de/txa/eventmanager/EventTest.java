package de.txa.eventmanager;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.txa.eventmanager.dto.EventDTO;
import de.txa.eventmanager.service.EventService;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/META-INF/spring/eventservice-context.xml" })
public class EventTest {
	
	public final Date date = new Date();
	@Inject
	private EventService es;

	@Test
	public void saveEvent() {
		EventDTO event1 = new EventDTO("baylennao",
				"moi ban tre nho mang theo co? va Wiskey",
				"Berlin TU Berlin Bibo");
		event1.setHostEmail("t@gmail.com");
		event1.setEventDate(date);
		
		EventDTO event2 = new EventDTO("happy birthday",
				"bay len nao la bay len nao",
				"Matrix Berlin");
		event2.setHostEmail("t@gmail.com");
		event2.setEventDate(date);		
		
		es.create(event1);
		es.create(event2);
		
		EventDTO e1 = es.findByEventName("baylennao").get(0);
		EventDTO e2 = es.findByEventName("happy birthday").get(0);
		
		System.out.println(e1.getEventName());
		es.inviteUserToEvent("xa@gmail.com", e1.getId());
		es.inviteUserToEvent("xa@gmail.com", e2.getId());
	}
	
	@Test
	public void findByEventName(){
		EventDTO event = es.findByEventName("baylennao").get(0);
		assertEquals("Bay len nao cac ban tre!!!", event.getEventName());
	}
	
	@Test
	public void findByUserEmail(){
		List<EventDTO> allEvents = es.findByUserEmail("t@gmail.com");
		for(EventDTO e : allEvents){
			System.out.println(e.getEventName());
		}
	}
	
	@Test
	public void findByDate(){
		System.out.println("Event By Date start Finding......");
		
		List<EventDTO> allEventsOnDate = es.findByDate(date);
		if(allEventsOnDate == null){
			System.out.println("list ist null !!!!!!!!!!!!!!!!!");
		}
		for(EventDTO e : allEventsOnDate){
			System.out.println(e.getEventName());
		}
	}
	
	@Test 
	public void getAllInvitedMember(){
		List<String> members = es.getAllInvitedMember((long) 11);
		for(String member : members) {
			System.out.println(member);
		}
	}
	
	@Test
	public void getAllAcceptedMember(){
		List<String> members = es.getAllAcceptedMember((long) 11, false);
		for(String member : members) {
			System.out.println(member);
		}
	}
	
	@Test
	public void getAllInvitesFromUser() {
		List<EventDTO> eventDTOs = es.getAllInvitesFromUser("xa@gmail.com");
		for(EventDTO eventDTO : eventDTOs) {
			System.out.println(eventDTO.getEventName());
		}
	}

	
	@Test 
	public void acceptInvite(){
		es.acceptInvite("xa@gmail.com", Long.valueOf(11) , false);
	}
	
	 @Test
	 public void deleteEvent(){
		 EventDTO event = es.findByEventName("baylennao").get(0);
		 Long i = event.getId();
		 System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF  "+ event.getId());
		 es.delete(i);
	 }
}
