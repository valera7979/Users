package com.my.example.users.demo.service;

import com.my.example.users.demo.model.User;
import com.my.example.users.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}


	public void deleteById(long id) {
		userRepository.deleteById(id);
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException(
				String.format("User with id %s not found", id)));
	}

	public User updateUser(Long id, User user) {
		User userInDb = findById(id);

		userInDb.setAdmin(user.isAdmin());
		userInDb.setName(user.getName());

		return userRepository.save(userInDb);
	}
}
