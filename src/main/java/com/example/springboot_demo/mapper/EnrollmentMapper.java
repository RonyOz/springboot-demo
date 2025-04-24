package com.example.springboot_demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.springboot_demo.dto.EnrollmentDTO;
import com.example.springboot_demo.entity.Enrollment;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    
    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "course.id", target = "courseId")
    EnrollmentDTO toDTO(Enrollment enrollment);

    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "courseId", target = "course.id")
    Enrollment toEntity(EnrollmentDTO dto); // Crea las entidades o las obtiene de la base de datos?

    void updateEntityFromDTO(EnrollmentDTO dto, @MappingTarget Enrollment enrollment);

}
