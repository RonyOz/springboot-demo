package com.example.springboot_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot_demo.service.EnrollmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    @Qualifier("enrollmentServiceImpl")
    EnrollmentService enrollmentService;

    @GetMapping("/")
    public String index(@RequestParam String param) {
        return "enrollmentPage";
    }
    

}
