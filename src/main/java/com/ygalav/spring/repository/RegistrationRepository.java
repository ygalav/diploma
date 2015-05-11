package com.ygalav.spring.repository;

import com.ygalav.spring.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository  extends JpaRepository<Registration, Integer> {
    List<Registration> findByStudentId(Integer id);
}
