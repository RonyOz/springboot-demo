package com.example.springboot_demo.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_demo.dto.CourseDTO;
import com.example.springboot_demo.dto.StudentDTO;
import com.example.springboot_demo.service.CourseService;
import com.example.springboot_demo.service.StudentService;

@RestController
@RequestMapping("api/v1/courses")
public class CourseRestController {
    
    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> all() {
        var courses = courseService.getAllCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @GetMapping("/{courseId}/students")
    public ResponseEntity<List<StudentDTO>> getStudentsByCourseId(@PathVariable Long courseId) {
        var students = studentService.getStudentsByCourse(courseId);
        return ResponseEntity.status(200).body(students);
    }
}
