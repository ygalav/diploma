package com.ygalav.spring.facade;

import com.ygalav.spring.dto.StudentDto;
import com.ygalav.spring.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StudentFacade {

    StudentDto save(StudentDto student);
    List<StudentDto> findAll();

    Student fromDto(StudentDto studentDto);

    StudentDto toDto(Student student);
}
