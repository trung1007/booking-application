package com.example.BookingApplication.service;


import com.example.BookingApplication.domain.User;
import com.example.BookingApplication.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

    public void handleSaveUser(User user) {
        this.userRepository.save(user);
    }
    @Transactional
    public void deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User not found with ID: " + id);
        }
    }
}
