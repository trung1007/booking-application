package com.example.BookingApplication.controller;

import com.example.BookingApplication.domain.User;
import com.example.BookingApplication.repository.UserRepository;
import com.example.BookingApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return this.userService.getUserById(id);
    }
    @PostMapping("/users/save")
    public void saveUser(@RequestBody User user) {
        this.userService.handleSaveUser(user);
    }
    @PutMapping("/users/save/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user) {
        User currentUser = this.userService.getUserById(id);
        this.userService.handleSaveUser(user);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
    }

}
