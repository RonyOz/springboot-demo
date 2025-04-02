package com.example.springboot_demo.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot_demo.entity.Course;
import com.example.springboot_demo.entity.Professor;
import com.example.springboot_demo.entity.Student;
import com.example.springboot_demo.repository.ProfessorRepository;
import com.example.springboot_demo.service.CourseService;
import com.example.springboot_demo.service.EnrollmentService;
import com.example.springboot_demo.service.StudentService;

@SpringBootTest
public class StudentServiceIntegrationTest {
    
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private ProfessorRepository professorRepository;

    @Test
    void getEnrolledStudents_WhenCourseHasStudents_ShouldReturnStudentList() {
        // Arrange

        Professor professor = new Professor();
        professor.setName("Alice Andrew");
        professorRepository.save(professor);

        Course course = new Course();
        course.setName("Computación en Internet II");
        course.setProfessor(professor);
        courseService.createCourse(course);


        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setProgram("Computer Science");
        studentService.createStudent(student1);

        Student student2 = new Student();
        student2.setName("Jane Doe");
        student2.setProgram("Computer Science");
        studentService.createStudent(student2);

        enrollmentService.enrollStudent(course.getId(), student1.getId());
        enrollmentService.enrollStudent(course.getId(), student2.getId());
        
        // Act
        List<Student> students = studentService.getEnrolledStudents(course.getId());

        // Assert

        assertEquals(2, students.size());
        
    }

}
