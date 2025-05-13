package com.example.springboot_demo.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_demo.dto.StudentDTO;
import com.example.springboot_demo.service.CourseService;
import com.example.springboot_demo.service.StudentService;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @Autowired 
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        
        var errors = studentDTO.validate();

        if (!errors.isEmpty() ) return ResponseEntity.badRequest().body(Map.of("errors", errors));

        studentService.createStudent(studentDTO);

        return ResponseEntity.status(201).body(studentDTO);
    }    

    @GetMapping("")
    public ResponseEntity<?> all(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        var students = studentService.getStudents(page, size);
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/{id}/courses") // 
    public ResponseEntity<?> getCoursesByStudentID(@PathVariable("id") Long id) {
        var courses = courseService.getCoursesByStudent(id);
        return ResponseEntity.status(200).body(courses);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") Long id, @RequestBody StudentDTO studentDTO) {
        var errors = studentDTO.validate();

        if (!errors.isEmpty() ) return ResponseEntity.badRequest().body(Map.of("errors", errors));
        
        studentService.updateStudent(id, studentDTO);

        return ResponseEntity.status(200).body(studentDTO);
    }

    // Get by program
    @GetMapping("/program/{program}")
    public ResponseEntity<List<StudentDTO>> getStudentsByProgram(@PathVariable("program") String program) {
        var students = studentService.getByProgram(program);
        return ResponseEntity.status(200).body(students);
    }
}
