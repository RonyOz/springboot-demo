package com.example.springboot_demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_demo.entity.Course;
import com.example.springboot_demo.repository.CourseRepository;
import com.example.springboot_demo.repository.EnrollmentRepository;
import com.example.springboot_demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCoursesByStudent(Long studentId) {
        var enrollments = enrollmentRepository.findByStudent_Id(studentId);
        return enrollments.stream().map(enrollment -> enrollment.getCourse()).toList();
    }

    @Override
    public Course createCourse(Course course) {
        
        if (courseRepository.existsByName(course.getName())) {
            throw new RuntimeException("Course already exists");
            
        } 

        courseRepository.save(course);


        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(long l) {
        return courseRepository.findById(l).get();
    }

	public void deleteCourse(long courseId) {
        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
        } else {
            throw new RuntimeException("Course not found");
            
        }
	}

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

}
