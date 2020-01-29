package com.my.example.users.demo.controller;

import com.my.example.users.demo.model.User;
import com.my.example.users.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
@AllArgsConstructor
public class UsersController {

	private final UserService userService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		return userService.save(new User(user.getId(), user.getName(), Instant.now(), user.isAdmin()));
	}

	@GetMapping
	public List<User> findAll() {
		Iterable<User> df = userService.findAll();
		return (List<User>) userService.findAll();
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") long id) {
		userService.deleteById(id);
	}
}
