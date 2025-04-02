package com.example.springboot_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot_demo.entity.Course;
import com.example.springboot_demo.service.CourseService;
import com.example.springboot_demo.service.ProfessorService;
import com.example.springboot_demo.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    @Qualifier("professorServiceImpl")
    private ProfessorService professorService;

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("professors", professorService.getprofessors());
        model.addAttribute("course", new Course());
        model.addAttribute("courses", courseService.getAllCourses());
        return "coursePage";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Course course) {
        courseService.createCourse(course);
        return "redirect:/course";
    }

    @GetMapping("/coursesByStudent/{id}")
    public String coursesByStudent(@RequestParam("id") long id, Model model) {
        model.addAttribute("courses", courseService.getCoursesByStudent(id));
        return "courseList";
    }

    @GetMapping("/{id}")
    public String getCourseDetail(@PathVariable("id") long id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        model.addAttribute("students", studentService.getStudentsByCourse(id));
        return "courseDetail";
    }
    


}