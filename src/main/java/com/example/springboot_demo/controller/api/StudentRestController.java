package com.example.springboot_demo.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_demo.dto.StudentDTO;
import com.example.springboot_demo.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        
        var errors = studentDTO.validate();

        if (!errors.isEmpty() ) return ResponseEntity.badRequest().body(Map.of("errors", errors));

        studentService.createStudent(studentDTO);

        return ResponseEntity.status(201).body(studentDTO);
    }    

    @GetMapping()
    public ResponseEntity<List<StudentDTO>> all(){
        var students = studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }
    
    
}
