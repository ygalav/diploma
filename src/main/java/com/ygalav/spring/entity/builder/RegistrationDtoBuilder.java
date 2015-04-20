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

    public RegistrationDto createRegistrationDto() {
        return new RegistrationDto(id, book, student);
    }
}
