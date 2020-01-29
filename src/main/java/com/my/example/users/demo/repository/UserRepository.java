package com.my.example.users.demo.repository;

import com.my.example.users.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
