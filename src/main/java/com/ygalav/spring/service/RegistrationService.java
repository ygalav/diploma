package com.ygalav.spring.service;

import com.ygalav.spring.entity.Book;
import com.ygalav.spring.entity.Registration;

import java.util.List;

public interface RegistrationService {
    List<Registration> findAll();
    Registration save(Registration registration);
    List<Registration> findByStudentId(Integer id);
}
