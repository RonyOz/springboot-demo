package com.example.springboot_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springboot_demo.entity.Student;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Hello desde Computación en Internet 2");
        return "home"; // Aquí renderizamos el archivo home.html en templates
    }

    @GetMapping("/detail")
    public String detalleEstudiante(Model model) {
        Student student = new Student();
        student.setName("Juan Pérez");
        student.setCode("20231234");
        student.setProgram("Ingeniería de Sistemas");

        model.addAttribute("student", student);
        return "detail";
    }
}