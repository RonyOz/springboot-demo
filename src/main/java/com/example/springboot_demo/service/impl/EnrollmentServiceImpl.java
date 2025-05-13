package com.example.springboot_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_demo.dto.EnrollmentDTO;
import com.example.springboot_demo.entity.Enrollment;
import com.example.springboot_demo.mapper.EnrollmentMapper;
import com.example.springboot_demo.repository.EnrollmentRepository;
import com.example.springboot_demo.repository.StudentRepository;
import com.example.springboot_demo.service.EnrollmentService;

import jakarta.transaction.Transactional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Enrollment enrollStudent(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentDTO);

        if (enrollment.getStudent().getId() != null) {
            var student = studentRepository.findById(enrollment.getStudent().getId()).orElseThrow();
            enrollment.setStudent(student);
            
        }
        enrollmentRepository.save(enrollment);

        return enrollment;
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    } 

}
