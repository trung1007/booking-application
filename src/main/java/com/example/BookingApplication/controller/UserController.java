package com.example.BookingApplication.controller;

import com.example.BookingApplication.domain.User;
import com.example.BookingApplication.repository.UserRepository;
import com.example.BookingApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model){
        return "hello";
    }


    @RequestMapping("/admin/user")
    public String getTableUser(Model model){
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }


    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model){
        String test = this.userService.helloService("service");
        model.addAttribute("user", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute("user") User user){
        this.userService.handleCreateUser(user);
        return "redirect:/admin/user";
    }
}
