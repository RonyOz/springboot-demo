package com.example.springboot_demo.repository;

import com.example.springboot_demo.entity.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByProgram(String program);

    // List<Student> findByEnrollmentsCourseId(Long courseId);

    int countByProgram(String program);

    Page<Student> findAll(Pageable pageable);

    Optional<Student> findById(Long studentId);

    Optional<Student> findByCode(String code);

}