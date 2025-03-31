package com.example.BookingApplication.controller;

import com.example.BookingApplication.domain.User;
import com.example.BookingApplication.repository.UserRepository;
import com.example.BookingApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/admin/user/{id}")
    public String getDetailUser(Model model, @PathVariable Long id){
        System.out.println(id);
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail-user";
    }


    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model){
        String test = this.userService.helloService("service");
        model.addAttribute("user", new User());
        return "admin/user/create";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdatePage(Model model, @PathVariable Long id){

        User user = this.userService.getUserById(id);
        model.addAttribute("user",user);
        return "admin/user/edit-user";
    }

    @RequestMapping(value = "/admin/user/{id}", method = RequestMethod.PUT)
    public String updateUser(Model model, @PathVariable Long id, @RequestBody User user) {

        System.out.println(user);
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "redirect:/admin/user";
    }


    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute("user") User user){
        this.userService.handleCreateUser(user);
        return "redirect:/admin/user";
    }
}
