package com.todos.services.impl;

import com.todos.models.User;
import com.todos.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User findUserById(Long userId) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(Long userId, User user) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Long userId) {
        return null;
    }
}
