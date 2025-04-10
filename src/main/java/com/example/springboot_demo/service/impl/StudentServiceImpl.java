package com.example.springboot_demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.springboot_demo.dto.StudentDTO;
import com.example.springboot_demo.entity.Enrollment;
import com.example.springboot_demo.mapper.StudentMapper;
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

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public void createStudent(StudentDTO student) {
        studentRepository.save(studentMapper.toEntity(student));
    }

    @Override
    public List<StudentDTO> getStudents() {
        return studentRepository.findAll().stream().map(student -> studentMapper.toDTO(student)).toList();
    }

    @Override
    public List<StudentDTO> getByProgram(String program) {
        return studentRepository.findByProgram(program).stream().map(student -> studentMapper.toDTO(student)).toList();
    }

    @Override
    public Page<StudentDTO> findAll(int page, int size) {
        return studentRepository.findAll(org.springframework.data.domain.PageRequest.of(page, size)).map(student -> studentMapper.toDTO(student));
    }

    @Override
    public List<StudentDTO> getEnrolledStudents(long courseId) {

        List<Enrollment> enrollments = enrollmentRepository.findByCourse_Id(courseId);
        return enrollments.stream().map(enrollment -> studentMapper.toDTO(enrollment.getStudent())).toList();

    }

    @Override
    public StudentDTO getStudentById(long id) {
        return studentMapper.toDTO(studentRepository.findById(id).orElse(null));
    }

    @Override
    public StudentDTO getStudentByCode(String code) {
        return studentMapper.toDTO(studentRepository.findByCode(code).orElse(null));
    }

    @Override
    public List<StudentDTO> getStudentsByCourse(long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourse_Id(courseId);
        return enrollments.stream().map(enrollment -> studentMapper.toDTO(enrollment.getStudent())).toList();
    }

    
}
