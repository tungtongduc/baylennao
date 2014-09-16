package de.txa.usermanagerservice.app;

import java.util.List;

import de.txa.usermanagerservice.dto.UserDTO;
import de.txa.usermanagerservice.service.UserService;
import de.txa.usermanagerservice.service.UserServiceFactory;

public class Application {
	
    public static void main(String[] args) {
        
        UserService userDao = UserServiceFactory.getInstance().getUserService();
        
        List<UserDTO> userDTOs = userDao.findUserByEmail("xa@gmail.com");
        
        for(UserDTO userDTO : userDTOs) {
        	System.out.println("toi la " + userDTO.getName());
        }
    }

}