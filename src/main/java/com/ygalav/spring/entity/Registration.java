package com.ygalav.spring.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Registration {
    @Id
    @GeneratedValue
    private Integer id;
    private Date releaseDate;
    private Date returnDate;
    private Date actualReturnDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;
    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;
    public Date getActualReturnDate() {return actualReturnDate;}

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDay(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }



}
