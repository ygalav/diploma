package com.ygalav.spring.facade.impl;

import com.ygalav.spring.dto.BookDto;
import com.ygalav.spring.dto.RegistrationDto;
import com.ygalav.spring.entity.Book;
import com.ygalav.spring.entity.Registration;
import com.ygalav.spring.entity.builder.BookBuilder;
import com.ygalav.spring.entity.builder.BookDtoBuilder;
import com.ygalav.spring.entity.builder.RegistrationBuilder;
import com.ygalav.spring.entity.builder.RegistrationDtoBuilder;
import com.ygalav.spring.facade.RegistrationFacade;
import com.ygalav.spring.service.BookService;
import com.ygalav.spring.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RegistrationFacadeImpl implements RegistrationFacade {

    @Autowired
    private RegistrationService registrationService;


    @Override
    public List<RegistrationDto> findAll() {
        List<Registration> registrations = registrationService.findAll();
        List<RegistrationDto> registrationDtos = new ArrayList<>();
        for (Registration registration : registrations){
            registrationDtos.add(toDto(registration));
        }
        return registrationDtos;
    }

    @Override
    public RegistrationDto save(RegistrationDto registrationDto) {
        Registration registration = registrationService.save(fromDto(registrationDto));
        return toDto(registration);
    }
    private RegistrationDto toDto(Registration  registration){
        return new RegistrationDtoBuilder()
                .setId(registration.getId())
                .setBook(registration.getBook())
                .setStudent(registration.getStudent())
                .createRegistrationDto();
    }

    private Registration fromDto(RegistrationDto registration){
        return new RegistrationBuilder()
                .setId(registration.getId())
                .setBook(registration.getBook())
                .setStudent(registration.getStudent())
                .createRegistration();
    }
}
