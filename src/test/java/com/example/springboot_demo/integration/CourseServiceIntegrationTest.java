// package com.example.springboot_demo.integration;

// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.example.springboot_demo.entity.Course;
// import com.example.springboot_demo.entity.Professor;
// import com.example.springboot_demo.repository.CourseRepository;
// import com.example.springboot_demo.repository.ProfessorRepository;
// import com.example.springboot_demo.service.CourseService;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertThrows;


// @SpringBootTest
// public class CourseServiceIntegrationTest {

//     @Autowired
//     private CourseService courseService;

//     @Autowired
//     private CourseRepository courseRepository;

//     @Autowired
//     private ProfessorRepository professorRepository;

//     private Professor professor;

//     @BeforeEach
//     void setup() {
//         professor = new Professor();
//         professor.setName("Alice Andrew");
//         professor = professorRepository.save(professor);
//     }

//     @AfterEach
//     void cleanup() {
//         courseRepository.deleteAll();
//         professorRepository.deleteAll();
//     }

//     @Test
//     void createCourse_WhenValid_ReturnsSavedCourse() {
//         // Arrange
//         Course course = new Course();
//         course.setName("Computación en Internet II");
//         course.setProfessor(professor);

//         // Act
//         Course savedCourse = courseService.createCourse(course);

//         // Assert
//         assertNotNull(savedCourse.getId());
//         assertEquals("Computación en Internet II", savedCourse.getName());
//         assertNotNull(savedCourse.getProfessor());
//         assertEquals(professor.getId(), savedCourse.getProfessor().getId());

//         // Verificar que realmente está en la BD
//         Course foundCourse = courseRepository.findById(savedCourse.getId()).orElse(null);
//         assertNotNull(foundCourse);
//         assertEquals("Computación en Internet II", foundCourse.getName());
//     }

//     @Test
//     void saveCourse_WhenCourseAlreadyExists_ShouldThrowException() {
//         // Arrange
//         Course course = new Course();
//         course.setName("Computación en Internet II");
//         course.setProfessor(professor);

//         courseService.createCourse(course);

//         // Act & Assert
//         Course course2 = new Course();
//         course2.setName("Computación en Internet II");
//         course2.setProfessor(professor);
        
//         assertThrows(RuntimeException.class, () -> courseService.createCourse(course2));
//     }





// }