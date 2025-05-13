package com.example.springboot_demo.dto;

import lombok.Data;

@Data
public class CourseDTO {
    private long id;
    private String name;
    private Long professorId; // solo el ID del profesor
    private int studentsCount; // cantidad de estudiantes

}