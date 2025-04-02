package com.example.springboot_demo.service;

import com.example.springboot_demo.entity.User;

public interface UserService {

    void createUser(User user);
    User findById(long id); 
    User findByEmail(String email);
    
}
