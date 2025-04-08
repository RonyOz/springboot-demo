package com.example.springboot_demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_demo.dto.CourseDTO;
import com.example.springboot_demo.entity.Course;
import com.example.springboot_demo.mapper.CourseMapper;
import com.example.springboot_demo.repository.CourseRepository;
import com.example.springboot_demo.repository.EnrollmentRepository;
import com.example.springboot_demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDTO> getCoursesByStudent(Long studentId) {
        var enrollments = enrollmentRepository.findByStudent_Id(studentId);
        return enrollments.stream().map(enrollment -> courseMapper.toDTO(enrollment.getCourse())).toList();
    }

    @Override
    public CourseDTO createCourse(CourseDTO course) {
        var entity = courseMapper.toEntity(course);
        
        if (courseRepository.existsByName(course.getName())) {
            throw new RuntimeException("Course already exists");
            
        }     

        courseRepository.save(entity);

        return course;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(courseMapper::toDTO).toList();
    }

    public CourseDTO getCourseById(long l) {
        return courseMapper.toDTO(courseRepository.findById(l).get());
    }

	public void deleteCourse(long courseId) {
        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
        } else {
            throw new RuntimeException("Course not found");
            
        }
	}

    @Override
    public CourseDTO getCourseById(Long id) {
        return courseMapper.toDTO(courseRepository.findById(id).get());
    }

}
