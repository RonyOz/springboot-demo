package com.example.springboot_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_demo.entity.Course;
import com.example.springboot_demo.entity.Enrollment;
import com.example.springboot_demo.entity.Student;
import com.example.springboot_demo.repository.EnrollmentRepository;
import com.example.springboot_demo.service.EnrollmentService;

import jakarta.transaction.Transactional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Transactional
    public Enrollment enrollStudent(Long courseId, Long studentId) {
        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(new Course(courseId));
        enrollment.setStudent(new Student(studentId));

        if (enrollmentRepository.existsByCourseIdAndStudentId(courseId, studentId)) {
            throw new RuntimeException("Student already enrolled in course");
        }
        enrollmentRepository.save(enrollment);

        return enrollment;
    }

}
