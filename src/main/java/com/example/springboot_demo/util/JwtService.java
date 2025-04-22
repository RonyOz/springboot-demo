package com.example.springboot_demo.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JwtService {

    @Value("${app.security.secretkey}")
    private String secret;

    @Value("${app.security.expirationMinutes}")
    private int expirationMinutes;

    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + 1000L * 60L * expirationMinutes);
    
        return Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .setClaims(createClaims(userDetails))
                    .setIssuedAt(now)
                    .setExpiration(expiry)
                    .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                    .compact();
    }

    public Map<String, Object> createClaims(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", userDetails.getUsername());
        claims.put("roles", userDetails.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()));
        return claims;
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

}