package com.todos.services;

import com.todos.models.User;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface UserService {

    Set<User> findAllUsers();

    User findUserById(Long userId);

    User createUser(User user);

    User updateUser(Long userId, User user);

    ResponseEntity<Void> deleteUserById(Long userId);
}
