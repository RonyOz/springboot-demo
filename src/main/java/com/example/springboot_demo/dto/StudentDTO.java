package com.example.springboot_demo.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private String code;
    private String program;
}
