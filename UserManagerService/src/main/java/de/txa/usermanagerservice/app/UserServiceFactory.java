package de.txa.usermanagerservice.app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.txa.usermanagerservice.service.UserService;

@Configuration
@EnableAutoConfiguration
public class UserServiceFactory {

	@SuppressWarnings("resource")
	public static UserService getUserService(){
		final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring-conf.xml");
		return (UserService) context.getBean("userService");
	}
}
