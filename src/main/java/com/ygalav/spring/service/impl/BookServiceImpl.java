package com.ygalav.spring.service.impl;

import com.ygalav.spring.entity.Book;
import com.ygalav.spring.repository.BookRepository;
import com.ygalav.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    @Override
    public Book findOne(Integer id){return bookRepository.findOne(id);}

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
