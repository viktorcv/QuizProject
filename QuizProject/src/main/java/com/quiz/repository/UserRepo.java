package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.login.UserLogin;

public interface UserRepo extends JpaRepository<UserLogin, Long> {

}
