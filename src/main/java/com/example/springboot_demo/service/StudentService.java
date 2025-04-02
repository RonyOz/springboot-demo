package com.example.springboot_demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.springboot_demo.entity.Student;


public interface StudentService {
    void createStudent(Student student);
    List<Student> getStudents();
    List<Student> getByProgram(String program);
    Page<Student> findAll(int page, int size);
    List<Student> getEnrolledStudents(long courseId);
    Student getStudentById(long id);
    Student getStudentByCode(String code);
    List<Student> getStudentsByCourse(long courseId);
}
