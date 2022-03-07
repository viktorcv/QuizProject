package com.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.quiz.login.UserLogin;
import com.quiz.repository.UserRepo;
import com.quiz.security.CustomUserDetails;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userr;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserLogin userl = UserRepo.findByEmail(email);
		if (userl == null) {
			throw new UsernameNotFoundException("User not Found");
			
		}
		return new CustomUserDetails(userl);
	}

}
