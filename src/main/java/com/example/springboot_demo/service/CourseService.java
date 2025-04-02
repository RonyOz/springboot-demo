package com.example.springboot_demo.service;

import java.util.List;

import com.example.springboot_demo.entity.Course;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> getCoursesByStudent(Long studentId);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
}
