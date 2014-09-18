package de.txa.usermanagerservice.app;

import java.util.List;

import de.txa.usermanagerservice.dto.UserDTO;
import de.txa.usermanagerservice.security.LoginService;
import de.txa.usermanagerservice.security.UserToLogin;
import de.txa.usermanagerservice.service.UserService;
import de.txa.usermanagerservice.service.ServiceFactory;

public class Application {
	
    public static void main(String[] args) {
        
        UserService userDao = ServiceFactory.getUserService();
        
        List<UserDTO> userDTOs = userDao.findUserByEmail("xa@gmail.com");
        
        for(UserDTO userDTO : userDTOs) {
        	System.out.println("toi la " + userDTO.getName());
        }
        
        LoginService loginService = new LoginService();
        UserToLogin user = loginService.getUser("xa@gmail.com");
        System.out.println(user.getUserRoll());
    }

}