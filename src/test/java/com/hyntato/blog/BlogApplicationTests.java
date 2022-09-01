package com.hyntato.blog;

import com.hyntato.blog.entity.User;
import com.hyntato.blog.repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class BlogApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Order(1)
	public void findUserById() {
		Optional<User> user = userRepository.findById(1);
		assertNotNull(user.get());
	}

	@Test
	@Order(2)
	public void findAllUsers() {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
	}

	@Test
	@Order(3)
	public void createUser() {
		User user = new User("hyntato", "hyntato@gamil.com");
		User savedUser = userRepository.save(user);

		User newUser = userRepository.findById(savedUser.getId()).get();
		assertEquals("hyntato", newUser.getName());
	}

}
