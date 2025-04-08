package com.example.springboot_demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.springboot_demo.dto.CourseDTO;
import com.example.springboot_demo.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "professor.id", target = "professorId")
    CourseDTO toDTO(Course course);

    @Mapping(source = "professorId", target = "professor.id")
    Course toEntity(CourseDTO dto);
    
    @Mapping(source = "professorId", target = "professor.id")
    void updateEntityFromDTO(CourseDTO dto, @MappingTarget Course course);
}