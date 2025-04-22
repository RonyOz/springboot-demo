package com.example.springboot_demo.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_demo.dto.CourseDTO;
import com.example.springboot_demo.service.CourseService;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    
    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> all() {
        var courses = courseService.getAllCourses();
        return ResponseEntity.status(0).body(courses);
    }

}
