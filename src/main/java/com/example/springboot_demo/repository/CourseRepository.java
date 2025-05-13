package com.example.springboot_demo.repository;

import com.example.springboot_demo.entity.Course;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByProfessorId(Long professorId);

    List<String> findDistinctNameByProfessorId(Long professorId);

    List<Course> findAll();

    Optional<Course> findById(long l);

    void deleteById(long courseId);

    boolean existsById(long courseId);
    
    boolean existsByName(String courseName);

    List<Course> findByNameContainingIgnoreCase(String name);


}