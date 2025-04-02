package com.example.springboot_demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.springboot_demo.entity.Enrollment;
import com.example.springboot_demo.entity.Student;
import com.example.springboot_demo.repository.EnrollmentRepository;
import com.example.springboot_demo.repository.StudentRepository;
import com.example.springboot_demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    // @Value("${app.pagination.size}") // Parametrizacion de la paginacion en application.properties
    // private int pageSize;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getByProgram(String program) {
        return studentRepository.findByProgram(program);
    }

    @Override
    public Page<Student> findAll(int page, int size) {
        return studentRepository.findAll(org.springframework.data.domain.PageRequest.of(page, size));
    }

    @Override
    public List<Student> getEnrolledStudents(long courseId) {

        List<Enrollment> enrollments = enrollmentRepository.findByCourse_Id(courseId);
        return enrollments.stream().map(enrollment -> enrollment.getStudent()).toList();

    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student getStudentByCode(String code) {
        return studentRepository.findByCode(code).orElse(null);
    }

    @Override
    public List<Student> getStudentsByCourse(long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourse_Id(courseId);
        return enrollments.stream().map(enrollment -> enrollment.getStudent()).toList();
    }

    
}
