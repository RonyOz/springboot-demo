package com.example.springboot_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springboot_demo.entity.Student;
import com.example.springboot_demo.service.CourseService;
import com.example.springboot_demo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @GetMapping("")
    public String getStudentPage(Model model) {
        model.addAttribute("students", studentService.getStudents());
        model.addAttribute("student", new Student());
        return "studentPage";
    }

    @PostMapping
    public String postCreateStudent(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}")
    public String getStudentPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("courses", courseService.getCoursesByStudent(id));
        return "studentDetail";
    }

}
