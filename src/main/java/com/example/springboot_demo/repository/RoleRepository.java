package com.example.springboot_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
    
}
