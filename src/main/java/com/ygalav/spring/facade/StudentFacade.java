package com.ygalav.spring.facade;

import com.ygalav.spring.dto.StudentDto;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StudentFacade {

    StudentDto save(StudentDto student);
    List<StudentDto> findAll();

}
