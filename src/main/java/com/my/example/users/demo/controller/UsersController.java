package com.my.example.users.demo.controller;

import com.my.example.users.demo.model.User;
import com.my.example.users.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class UsersController {

	@Autowired
	UserRepository repository;

	@PostMapping(value = "/user")
	public void addUser(@RequestBody User user) {

		repository.save(new User(user.getId(), user.getName(), Instant.now(), user.isAdmin()));
	}

	@GetMapping(value="/users")
	public Iterable<User> findAll() {

		return repository.findAll();
	}

	@GetMapping(value="/user/{name}")
	public Iterable<User> findByName(@PathVariable("name") String name) {

		return repository.findByName(name);
	}

	@DeleteMapping(value="/user/{id}")
	public void deleteById(@PathVariable("id") long id) {

		repository.deleteById(id);
	}

	@DeleteMapping(value="/users")
	public void deleteAll() {

		repository.deleteAll();
	}
}
