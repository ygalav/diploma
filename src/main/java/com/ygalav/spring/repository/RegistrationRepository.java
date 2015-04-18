package com.ygalav.spring.repository;

import com.ygalav.spring.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository  extends JpaRepository<Registration, Integer>{
}
