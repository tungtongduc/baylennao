package de.txa.web;

import javax.inject.Inject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.txa.eventmanager.dto.EventDTO;
import de.txa.eventmanager.service.EventService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/META-INF/spring/eventservice-context.xml" })
public class EventTest {

	@Inject
	private EventService es;

//	@Test
	public void saveEvent() {
		EventDTO event = new EventDTO("baylennao",
				"moi ban tre nho mang theo co? va Wiskey",
				"Berlin TU Berlin Bibo");
		es.create(event);
	}
	
//	@Test
	public void findByName(){
		EventDTO event = es.findByEventName("baylennao").get(0);
		assertEquals("Bay len nao cac ban tre!!!", event.getEventName());
		
	}
	
	 @Test
	 public void deleteEvent(){
		 EventDTO event = es.findByEventName("baylennao").get(0);
//		 Long i = event.getId();
		 System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF  "+ event.getId());
//		 es.delete(i);
	 }
}
