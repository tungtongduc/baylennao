package de.txa.usermanager.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.txa.usermanager.entity.UserEntity;
import de.txa.usermanager.entity.UserRoll;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final LoginService loginService = new LoginService();
	
	public CustomUserDetailsService() {
	}

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			UserEntity user = loginService.getUser(email);
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			return new org.springframework.security.core.userdetails.User(
					user.getEmail(), user.getPassword(), enabled,
					accountNonExpired, credentialsNonExpired, accountNonLocked,
					getAuthorities(UserRoll.GAST));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Collection<GrantedAuthority> getAuthorities(UserRoll userRoll) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		if(userRoll == null) {
			authorities.add(new SimpleGrantedAuthority(UserRoll.GAST.toString()));
		}else if(userRoll.equals(UserRoll.GAST)) {
			authorities.add(new SimpleGrantedAuthority(UserRoll.GAST.toString()));
		}else if(userRoll.equals(UserRoll.ADMIN)) {
			authorities.add(new SimpleGrantedAuthority(UserRoll.ADMIN.toString()));
			authorities.add(new SimpleGrantedAuthority(UserRoll.GAST.toString()));
		}else {
			authorities.add(new SimpleGrantedAuthority(UserRoll.ADMIN.toString()));
			authorities.add(new SimpleGrantedAuthority(UserRoll.GAST.toString()));
			authorities.add(new SimpleGrantedAuthority(UserRoll.HOST.toString()));
		}
		return authorities;
	}
}
