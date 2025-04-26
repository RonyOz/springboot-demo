package com.example.springboot_demo.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_demo.dto.EnrollmentDTO;
import com.example.springboot_demo.service.EnrollmentService;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrrollmentRestController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<?> postEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
        var errors = enrollmentDTO.validate();
        if (!errors.isEmpty()) return ResponseEntity.badRequest().body(Map.of("errors", errors));
        
        enrollmentService.enrollStudent(enrollmentDTO);

        return ResponseEntity.status(201).body(enrollmentDTO);
    }

}
