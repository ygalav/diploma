package com.ygalav.spring.facade;

import com.ygalav.spring.dto.BookDto;
import com.ygalav.spring.dto.RegistrationDto;
import com.ygalav.spring.entity.Registration;

import java.util.List;

public interface RegistrationFacade {
    List<RegistrationDto> findAll();
    RegistrationDto save(RegistrationDto registrationDto);

}
