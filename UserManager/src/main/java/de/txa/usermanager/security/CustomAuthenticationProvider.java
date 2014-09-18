package de.txa.usermanager.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	private CustomUserDetailsService userDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;

		String username = String.valueOf(auth.getPrincipal());	
		String password = String.valueOf(auth.getCredentials());
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		if(userDetails == null){
			throw new BadCredentialsException("Bad Credentials");
		}
		
		if(!userDetails.getPassword().equals(password)){
			throw new BadCredentialsException("Bad Credentials");
		}

		return new  UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

	public CustomUserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(CustomUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

}
