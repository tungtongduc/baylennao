package de.txa.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.txa.entity.UserEntity;
import de.txa.entity.UserRoll;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	LoginService loginService = new LoginService();

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try {
			UserEntity user = loginService.getUser(username);
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			return new org.springframework.security.core.userdetails.User(
					user.getU_Name(), user.getPassword(), enabled,
					accountNonExpired, credentialsNonExpired, accountNonLocked,
					getAuthorities(user.getU_Roll()));
		} catch (Exception e) {
			return null;
		}
	}

	public Collection<GrantedAuthority> getAuthorities(UserRoll userRoll) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority(UserRoll.ADMIN.toString()));
		authorities.add(new SimpleGrantedAuthority(UserRoll.GAST.toString()));
		authorities.add(new SimpleGrantedAuthority(UserRoll.HOST.toString()));

		return authorities;
	}
}
