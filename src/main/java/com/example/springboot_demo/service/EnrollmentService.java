package com.example.springboot_demo.service;

import com.example.springboot_demo.dto.EnrollmentDTO;
import com.example.springboot_demo.entity.Enrollment;

public interface EnrollmentService {

    Enrollment enrollStudent(EnrollmentDTO enrollmentDTO);
    void deleteEnrollment(Long id);
}
