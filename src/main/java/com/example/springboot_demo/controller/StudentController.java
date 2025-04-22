package com.example.springboot_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_demo.service.StudentService;


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
