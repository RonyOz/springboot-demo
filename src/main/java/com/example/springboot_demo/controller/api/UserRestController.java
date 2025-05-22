package com.example.springboot_demo.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_demo.service.impl.CustomUserDetailsService;
import com.example.springboot_demo.util.JwtService;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/me") // Return USERDTO
    public ResponseEntity<?> getCurrentUser(@RequestParam String token) {
        try {
            String username = jwtService.extractAllClaims(token).getSubject();
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
            return ResponseEntity.ok(userDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }
}
