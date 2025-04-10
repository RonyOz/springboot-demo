package com.example.springboot_demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.springboot_demo.dto.StudentDTO;

public interface StudentService {
    void createStudent(StudentDTO student);
    List<StudentDTO> getStudents();
    List<StudentDTO> getByProgram(String program);
    Page<StudentDTO> findAll(int page, int size);
    List<StudentDTO> getEnrolledStudents(long courseId);
    StudentDTO getStudentById(long id);
    StudentDTO getStudentByCode(String code);
    List<StudentDTO> getStudentsByCourse(long courseId);
}
