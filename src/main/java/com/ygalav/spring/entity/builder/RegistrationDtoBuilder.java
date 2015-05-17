package com.ygalav.spring.entity.builder;

import com.ygalav.spring.dto.BookDto;
import com.ygalav.spring.dto.RegistrationDto;
import com.ygalav.spring.dto.StudentDto;
import com.ygalav.spring.entity.Book;
import com.ygalav.spring.entity.Student;

public class RegistrationDtoBuilder {
    private Integer id;
    private BookDto book;
    private StudentDto student;
    private String returnDate;
    private String actualReturnDate;

    public RegistrationDtoBuilder setId(Integer id) {
        this.id = id;
        return this;
    }


    public RegistrationDtoBuilder setBook(BookDto book) {
        this.book = book;
        return this;
    }

    public RegistrationDtoBuilder setStudent(StudentDto student) {
        this.student = student;
        return this;
    }

    public RegistrationDtoBuilder setReturnDate(String returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public RegistrationDtoBuilder setActualReturnDate(String actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
        return this;
    }

    public RegistrationDto createRegistrationDto() {
        RegistrationDto registrationDto =new RegistrationDto();
        registrationDto.setId(this.id);
        registrationDto.setBook(this.book);
        registrationDto.setStudent(this.student);
        registrationDto.setReturnDate(this.returnDate);
        registrationDto.setActualReturnDate(this.actualReturnDate);
        return registrationDto;
    }
}
