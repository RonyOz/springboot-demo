package com.example.springboot_demo.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private String code;
    private String program;

    public List<String> validate() {
        List<String> errors = new ArrayList<>();

        if (name == null || name.isEmpty()) {
            errors.add("Name cannot be null or empty");
        }
        if (code == null || code.isEmpty()) {
            errors.add("Code cannot be null or empty");
        }
        if (program == null || program.isEmpty()) {
            errors.add("Program cannot be null or empty");
        }

        return errors;
    }

}
