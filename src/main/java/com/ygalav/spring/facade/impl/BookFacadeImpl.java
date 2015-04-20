package com.ygalav.spring.facade.impl;

import com.ygalav.spring.dto.BookDto;
import com.ygalav.spring.entity.Book;
import com.ygalav.spring.entity.builder.BookBuilder;
import com.ygalav.spring.entity.builder.BookDtoBuilder;
import com.ygalav.spring.facade.BookFacade;
import com.ygalav.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookFacadeImpl implements BookFacade{

    @Autowired
    private BookService bookService;

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookService.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books){
            bookDtos.add(toDto(book));
        }
        return bookDtos;
    }

    @Override
    public BookDto save(BookDto bookDto) {
        Book book = bookService.save(fromDto(bookDto));
        return toDto(book);
    }

@Override
    public BookDto toDto(Book book){
        return new BookDtoBuilder()
                .setId(book.getId())
                .setName(book.getName())
                .setAuthor(book.getAuthor())
                .setCode(book.getCode())
                .createBookDto();
    }
@Override
    public Book fromDto(BookDto book){
        return new BookBuilder()
                .setId(book.getId())
                .setName(book.getName())
                .setAuthor(book.getAuthor())
                .setCode(book.getCode())
                .createBook();
    }
}
