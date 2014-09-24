package de.txa.baylennao;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.txa.eventmanager.service.EventService;
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
	
	@Inject
	private EventService eventService;
	
	private Authentication auth;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,
			@RequestParam(value = "logoutSuccess", required = false) String logoutSuccess,
			@RequestParam(value = "loginFalue", required = false) String loginFalue) {

		if(istLogin()) {
		    logger.info(auth.getName() + " ist in system!!");
		    model.addAttribute("user", userService.findByEmail(auth.getName()));	
		}
		
		if(loginFalue != null) {
			model.addAttribute("loginFalue", "login falue");
		}
		if(logoutSuccess != null) {
			model.addAttribute("infoMessage", "logoutSuccess");
		}
		return "index";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Locale locale, Model model,
			@RequestParam(value = "newRegister", required = false) String newRegister) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		if (newRegister != null) {
			model.addAttribute("msg", "You muss logout before new Register!");
		}
		
		if(istLogin()) {
		    logger.info(auth.getName() + " ist in system!!");
		    model.addAttribute("user", userService.findByEmail(auth.getName()));
	        
			return "profile";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	public String updateUser(Model model, UserDTO userDTO, BindingResult result) {
		userService.update(userDTO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model,
						@RequestParam(value = "error", required = false) String error,
						@RequestParam(value = "logout", required = false) String logout,
						@RequestParam(value = "registerSuceess", required = false) String registerSuceess) {

		if (istLogin()) {

		    /* The user is logged in :) */			
			return "redirect:/";
		    
		}
		
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		
		if (registerSuceess != null) {
			model.addAttribute("msg", "Registration successfully, you can login now!");
		}
		
		return "login";
	}
	
	@RequestMapping(value="/profile/changepassword", method = RequestMethod.POST)
	public String changePassword(Model model, 
			@RequestParam(value = "old_password", required = true) String oldPassword,
			@RequestParam(value = "new_password", required = true) String newPassword,
			@RequestParam(value = "re_password", required = true) String rePassword){
		if(newPassword.equals(rePassword)){
			if(istLogin()){
				if(userService.checkPassswordBeforeChange(oldPassword, auth.getName())){
					return "redirect:/?changePasswordSuccess";
				}
			}
		}
		return "redirect:/?changePasswordFailure";
	}
	
	@RequestMapping(value = "/register/add", method = RequestMethod.POST)
	public String addUser(Model model, @Valid UserDTOtoCreate userDTOtoCreate, 
					@RequestParam(value = "rePassword", required = true) String rePassword,
					BindingResult result) {
		if (result.hasErrors()) {
			for (FieldError fieldError : result.getFieldErrors()) {
//				model.addAttribute(fieldError.getField(), CSS_ERROR_TAG);
				logger.error(fieldError.getField());
			}
		} else {
			final UserDTO userDTO = userService.findByEmail(userDTOtoCreate.getEmail());
			
			if (userDTO != null && userDTO.getEmail() != null) {
				return "redirect:/register?userExist";
			}
			
			if(StringUtils.pathEquals(userDTOtoCreate.getPassword(), rePassword)) {
				userService.create(userDTOtoCreate);
				return "redirect:/?registerSuceess";
			}
		}
		return "redirect:/register?errorRegister";
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
