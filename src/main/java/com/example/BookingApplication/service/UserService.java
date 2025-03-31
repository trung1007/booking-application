package com.example.BookingApplication.service;


import com.example.BookingApplication.domain.User;
import com.example.BookingApplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String helloService(String name) {
        return "Hello " + name;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public void handleCreateUser(User user) {
        this.userRepository.save(user);
    }
}
