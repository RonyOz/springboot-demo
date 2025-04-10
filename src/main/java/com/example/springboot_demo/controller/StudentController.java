package com.example.springboot_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_demo.dto.StudentDTO;
import com.example.springboot_demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    // @GetMapping("/{id}/courses")
    // public String getMethodName(@RequestParam String param) {

    //     List<StudentDTO> students = studentService.getStudentsByCourse(param);
    // 
    
}
