package com.example.springboot_demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_demo.entity.Professor;
import com.example.springboot_demo.repository.ProfessorRepository;
import com.example.springboot_demo.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> getprofessors() {
        return professorRepository.findAll();
    }
    
}
