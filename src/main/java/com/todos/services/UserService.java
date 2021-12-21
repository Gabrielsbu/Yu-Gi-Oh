package com.todos.services;

import com.todos.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> findAllUsers();

    User findUserById(Long userId);

    User createUser(User user);

    User updateUser(Long userId, User user);

    ResponseEntity<Void> deleteUserById(Long userId);
}
