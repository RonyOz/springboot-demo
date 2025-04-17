package com.example.springboot_demo.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
    
    public AuthRequest() {
    }

}
