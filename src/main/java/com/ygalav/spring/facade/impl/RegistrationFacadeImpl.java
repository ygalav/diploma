package com.ygalav.spring.facade.impl;

import com.ygalav.spring.dto.BookDto;
import com.ygalav.spring.dto.RegistrationDto;
import com.ygalav.spring.dto.StudentDto;
import com.ygalav.spring.entity.Book;
import com.ygalav.spring.entity.Registration;
import com.ygalav.spring.entity.Student;
import com.ygalav.spring.entity.builder.BookBuilder;
import com.ygalav.spring.entity.builder.BookDtoBuilder;
import com.ygalav.spring.entity.builder.RegistrationBuilder;
import com.ygalav.spring.entity.builder.RegistrationDtoBuilder;
import com.ygalav.spring.facade.BookFacade;
import com.ygalav.spring.facade.RegistrationFacade;
import com.ygalav.spring.facade.StudentFacade;
import com.ygalav.spring.service.BookService;
import com.ygalav.spring.service.RegistrationService;
import com.ygalav.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class RegistrationFacadeImpl implements RegistrationFacade {
@Autowired
private StudentFacade studentFacade;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
private BookFacade bookFacade;
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;


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
       BookDto bookDto=bookFacade.toDto(registration.getBook());
        StudentDto studentDto=studentFacade.toDto(registration.getStudent());
        return new RegistrationDtoBuilder()
                .setId(registration.getId())
                .setBook(bookDto)
                .setStudent(studentDto)
                .createRegistrationDto();
    }

    private Registration fromDto(RegistrationDto registration){
       Book book=bookService.findOne(registration.getBook().getId());
        Student student=studentService.findOne(registration.getStudent().getId());
        return new RegistrationBuilder()
                .setId(registration.getId())
                .setBook(book)
                .setStudent(student)
                .createRegistration();
    }
}
