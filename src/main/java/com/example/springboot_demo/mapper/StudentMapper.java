package com.example.springboot_demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.springboot_demo.dto.StudentDTO;
import com.example.springboot_demo.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO toDTO(Student student);

    Student toEntity(StudentDTO dto);
    
    void updateEntityFromDTO(StudentDTO dto, @MappingTarget Student course);
}