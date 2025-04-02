package com.example.springboot_demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot_demo.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    
    List<Enrollment> findByStudent_Id(long studentId);

    List<Enrollment> findByCourse_Id(Long courseId);

    boolean existsByCourseIdAndStudentId(Long courseId, Long studentId);

}
