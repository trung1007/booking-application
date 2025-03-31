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
    public String getHomePage(Model model) {
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getTableUser(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }

    @RequestMapping("/admin/user/{id}")
    public String getDetailUser(Model model, @PathVariable Long id) {
        System.out.println(id);
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail-user";
    }


    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        String test = this.userService.helloService("service");
        model.addAttribute("user", new User());
        return "admin/user/create";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdatePage(Model model, @PathVariable Long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("user", currentUser);
        return "admin/user/edit-user";
    }

    @PostMapping("/admin/user/update")
    public String updateUser(Model model, @ModelAttribute("user") User user) {
        User currentUser = this.userService.getUserById(user.getId());
        if(currentUser !=null){
            currentUser.setAddress(user.getAddress());
            currentUser.setEmail(user.getEmail());
            currentUser.setFullName(user.getFullName());
            currentUser.setPhoneNumber(user.getPhoneNumber());
        }
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }
//    @RequestMapping(value = "/admin/user/edit/{id}", method = RequestMethod.POST)
//    public String updateUser(Model model, @PathVariable Long id, @RequestBody User user) {
//        model.addAttribute("users",user);
//        return "redirect:/admin/user/table-user";
//    }


    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute("user") User user) {
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }
}
