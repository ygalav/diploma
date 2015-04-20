package com.ygalav.spring.service;

import com.ygalav.spring.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findOne(Integer id);

    Book save(Book book);
}
