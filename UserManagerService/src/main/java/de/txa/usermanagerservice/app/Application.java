package de.txa.usermanagerservice.app;

import de.txa.usermanagerservice.dto.UserDTO;
import de.txa.usermanagerservice.service.UserService;
public class Application {
	
    public static void main(String[] args) {
        UserService userService = UserServiceFactory.getUserService();
        UserDTO user1 = userService.findByName("xuan anh").get(0);
        System.out.println(user1.getEmail());
    }

}