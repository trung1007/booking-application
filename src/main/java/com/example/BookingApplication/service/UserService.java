package com.example.BookingApplication.service;


import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String helloService(String name) {
        return "Hello " + name;
    }
}
