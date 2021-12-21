package com.todos.services.impl;

import com.todos.models.User;
import com.todos.repositories.UserRepository;
import com.todos.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User user) {
        User userExistent = userRepository.getById(userId);
        userExistent.setFullName(user.getFullName());
        userExistent.setEmail(user.getEmail());
        userExistent.setPassword(user.getPassword());
        userExistent.setAvatarUri(user.getAvatarUri());
        userExistent.setAddress(user.getAddress());
        userExistent.setTodos(null);

        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Long userId) {
        User userExistent = findUserById(userId);

        userRepository.deleteById(userExistent.getUserId());
        return ResponseEntity.noContent().build();
    }
}
