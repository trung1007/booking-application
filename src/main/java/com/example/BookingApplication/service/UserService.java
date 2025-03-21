package com.example.BookingApplication.service;


import com.example.BookingApplication.domain.User;
import com.example.BookingApplication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String helloService(String name) {
        return "Hello " + name;
    }

    public void handleCreateUser(User user) {
        this.userRepository.save(user);
    }
}
