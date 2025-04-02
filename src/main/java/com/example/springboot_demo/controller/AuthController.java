package com.example.springboot_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.springboot_demo.entity.Role;
import com.example.springboot_demo.entity.User;
import com.example.springboot_demo.service.RoleService;
import com.example.springboot_demo.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AuthController {

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signupGet(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    
}
