package com.example.springboot_demo.service;

import java.util.List;

import com.example.springboot_demo.dto.CourseDTO;

public interface CourseService {
    CourseDTO createCourse(CourseDTO course);
    List<CourseDTO> getCoursesByStudent(Long studentId);
    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(Long id);
    List<CourseDTO> filterCoursesByName(String name);
}
