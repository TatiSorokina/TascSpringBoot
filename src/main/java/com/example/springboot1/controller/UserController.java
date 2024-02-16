package com.example.springboot1.controller;

import com.example.springboot1.model.User;
import com.example.springboot1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/addUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String editUser(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.editUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
