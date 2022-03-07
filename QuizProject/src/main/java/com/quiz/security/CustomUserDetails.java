package com.quiz.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.quiz.login.UserLogin;

public class CustomUserDetails implements UserDetails {
	
	private UserLogin userL;
	
	

	public CustomUserDetails(UserLogin userL) {
		this.userL = userL;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return userL.getPassword();
	}

	@Override
	public String getUsername() {
		return userL.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
