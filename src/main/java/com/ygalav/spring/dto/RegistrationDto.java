package com.ygalav.spring.dto;

import com.ygalav.spring.entity.Book;
import com.ygalav.spring.entity.Registration;
import com.ygalav.spring.entity.Student;

import java.util.Date;

public class RegistrationDto {
    private Integer id;
    private BookDto book;
    private StudentDto student;

    public RegistrationDto(Integer id, BookDto book, StudentDto student) {
        this.id = id;
        this.book=book;
        this.student=student;
    }

    public RegistrationDto(BookDto book) {
        this.book = book;
    }

    public RegistrationDto(StudentDto student) {
        this.student = student;
    }

    public RegistrationDto() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }


}
