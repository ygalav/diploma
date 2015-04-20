package com.ygalav.spring.entity.builder;

import com.ygalav.spring.dto.BookDto;
import com.ygalav.spring.dto.StudentDto;
import com.ygalav.spring.entity.Book;
import com.ygalav.spring.entity.Registration;
import com.ygalav.spring.entity.Student;

import java.util.Date;

public class RegistrationBuilder {
    private Integer id;
    private Book book;
    private Student student;
    private Date releaseDate;
    private Date returnDate;

    public RegistrationBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public RegistrationBuilder setBook(Book book) {
        this.book = book;
        return this;
    }

    public RegistrationBuilder setStudent(Student student) {
        this.student = student;
        return this;
    }

    public RegistrationBuilder setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public RegistrationBuilder setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public Registration createRegistration() {
        Registration registration = new Registration();
        registration.setId(id);
        registration.setBook(book);
        registration.setStudent(student);
        registration.setReleaseDay(releaseDate);
        registration.setReturnDate(returnDate);
        return registration;

    }
}
