package com.my.example.users.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class UsersController {

	@GetMapping(value = "/hello")
	public List<String> helloWorld() {
		List<String> helloWorlds = new LinkedList<>();
		helloWorlds.add("Hello");
		helloWorlds.add("world!!");

		return helloWorlds;
	}
}
