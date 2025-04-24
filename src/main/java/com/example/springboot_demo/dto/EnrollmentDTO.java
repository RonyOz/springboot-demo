package com.example.springboot_demo.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class EnrollmentDTO {
    private Long studentId;
    private Long courseId;

    public List<String> validate() {
        List<String> errors = new ArrayList<>();

        if (studentId == null) {
            errors.add("Student ID cannot be null");
        }
        if (courseId == null) {
            errors.add("Course ID cannot be null");
        }

        return errors;
    }
}
