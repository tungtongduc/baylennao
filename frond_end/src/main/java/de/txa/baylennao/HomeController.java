package de.txa.baylennao;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.txa.usermanager.dto.UserDTO;
import de.txa.usermanager.dto.UserDTOtoCreate;
import de.txa.usermanager.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private UserService userService;
	
//	@Inject
//	private EventService eventService;
	
	private Authentication auth;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		if(istLogin()) {
		    model.addAttribute("user", userService.findByEmail(auth.getName()));
		}
		return "index";
	}
	
	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	public String updateUser(Model model, UserDTO userDTO, BindingResult result) {
		userService.update(userDTO);
		return "redirect:/?infoMessage=profileUpdateSuccess";
	}
	
	@RequestMapping(value="/profile/changepassword", method = RequestMethod.POST)
	public String changePassword(Model model, 
			@RequestParam(value = "old_password", required = true) String oldPassword,
			@RequestParam(value = "new_password", required = true) String newPassword,
			@RequestParam(value = "re_password", required = true) String rePassword){
		
		if(newPassword.equals(rePassword)){
			if(istLogin()){
				if(userService.checkPassswordBeforeChange(oldPassword, auth.getName())){
					userService.changePassword(newPassword, auth.getName());
					return "redirect:/?infoMessage=changePasswordSuccess";
				}
			}
		}
		return "redirect:/?infoMessage=changePasswordFailure";
	}
	
	@RequestMapping(value = "/register/add", method = RequestMethod.POST)
	public String addUser(Model model, @Valid UserDTOtoCreate userDTOtoCreate, 
					@RequestParam(value = "rePassword", required = true) String rePassword) {
		final UserDTO userDTO = userService.findByEmail(userDTOtoCreate.getEmail());
		
		if (userDTO != null && userDTO.getEmail() != null) {
			return "redirect:/?registerInfo=userExist";
		}
		
		if(StringUtils.pathEquals(userDTOtoCreate.getPassword(), rePassword)) {
			userService.create(userDTOtoCreate);
			return "redirect:/?loginInfo=registerSuceess";
		}
		return "redirect:/?registerInfo=errorRegister";
	}
	
	private boolean istLogin() {
		auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {

		    /* The user is logged in :) */			
			return true;
		}
		return false;
	}
}
