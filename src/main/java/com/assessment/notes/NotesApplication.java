package com.assessment.notes;

import com.assessment.notes.domain.User;
import com.assessment.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class NotesApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		User user1 = new User();
		user1.setPassword("password");
		user1.setEmail("pzeng@gmail.com");
		User user2 = new User();
		user2.setPassword("password");
		user2.setEmail("paul@gmail.com");
		userService.createUser(user1);
	}
}
