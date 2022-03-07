package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quiz.login.UserLogin;



public interface UserRepo extends JpaRepository<UserLogin, Long> {

	@Query("SELECT u FROM UserLogin u WHERE u.email = ?1")
	static
	UserLogin findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
