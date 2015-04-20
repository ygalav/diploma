package com.ygalav.spring.service;

import com.ygalav.spring.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    
    Student save(Student student);
    
    List<Student> findAll();

    Student findOne(Integer id);
}
