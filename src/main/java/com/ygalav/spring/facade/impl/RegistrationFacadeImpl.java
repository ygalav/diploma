package com.ygalav.spring.facade.impl;

import com.ygalav.spring.dto.BookDto;
import com.ygalav.spring.dto.RegistrationDto;
import com.ygalav.spring.dto.StudentDto;
import com.ygalav.spring.entity.Book;
import com.ygalav.spring.entity.Registration;
import com.ygalav.spring.entity.Student;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy");

    @Override
    public List<RegistrationDto> findAll() {
        return toDtoList(registrationService.findAll());
    }

    @Override
    public RegistrationDto save(RegistrationDto registrationDto) {
        Registration registration = fromDto(registrationDto);
        if (registration.getReleaseDate() == null) {
            registration.setReleaseDay(new Date());
        }
        registration = registrationService.save(registration);
        return toDto(registration);
    }

    @Override
    public List<RegistrationDto> findByStudentId(Integer id) {
        return toDtoList(registrationService.findByStudentId(id));
    }

    private RegistrationDto toDto(Registration  registration){
        BookDto bookDto=bookFacade.toDto(registration.getBook());
        StudentDto studentDto=studentFacade.toDto(registration.getStudent());
        String returnDate = convertDateToString(registration.getReturnDate());
        return new RegistrationDtoBuilder()
                .setId(registration.getId())
                .setBook(bookDto)
                .setReturnDate(returnDate)
                .setStudent(studentDto)
                .createRegistrationDto();
    }

    private List<RegistrationDto> toDtoList(List<Registration> registrations){
        List<RegistrationDto> registrationDtos = new ArrayList<>();
        for (Registration registration : registrations){
            registrationDtos.add(toDto(registration));
        }
        return registrationDtos;
    }

    private Registration fromDto(RegistrationDto registration){
       Book book=bookService.findOne(registration.getBook().getId());
        Student student=studentService.findOne(registration.getStudent().getId());
        Date returnDate = convertStringToDate(registration.getReturnDate());
        return new RegistrationBuilder()
                .setId(registration.getId())
                .setBook(book)
                .setStudent(student)
                .setReturnDate(returnDate)
                .createRegistration();
    }

    private Date convertStringToDate(String dateString){
        Date date = null;
        try {
            date = DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private String convertDateToString(Date date){
        if (date == null){
            return null;
        }
        return DATE_FORMAT.format(date);
    }
}
