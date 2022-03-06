package com.quiz;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.quiz.login.UserLogin;
import com.quiz.repository.UserRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserLoginRepoTest {

	@Autowired
	private UserRepo userRT;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	public void testCreateUser() {
		UserLogin user = new UserLogin();
		user.setEmail("viktor.cvetkovski.c7@gmail.com");
		user.setPassword("12345678");
		user.setFirstName("Viktor");
		user.setLastName("Cvetkovski");	
		
		UserLogin savedUser = userRT.save(user);
		
		UserLogin existUser = entityManager.find(UserLogin.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
}
