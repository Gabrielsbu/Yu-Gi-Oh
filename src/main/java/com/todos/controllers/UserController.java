package com.todos.controllers;

import com.todos.models.Todo;
import com.todos.models.User;
import com.todos.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.findAllUsers();
    }
    
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.findUserById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, User user){
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        return userService.deleteUserById(userId);
    }
}
