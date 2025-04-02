package com.example.springboot_demo.service;

import com.example.springboot_demo.entity.Enrollment;

public interface EnrollmentService {

    Enrollment enrollStudent(Long studentId, Long courseId);
}
