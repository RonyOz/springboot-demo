package com.example.springboot_demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot_demo.entity.Professor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @GetMapping("")
    public String getProfessorPage(Model model) {
        return "professorPage";
    }
    

    @PostMapping("/create")
    public String postCreateProfessor(@RequestBody Professor p) {
        return "home";
    }
    
    
}
