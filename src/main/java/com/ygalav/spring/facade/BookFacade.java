package com.ygalav.spring.facade;

import com.ygalav.spring.dto.BookDto;
import com.ygalav.spring.entity.Book;

import java.util.List;

public interface BookFacade {
    List<BookDto> findAll();
    BookDto save(BookDto bookDto);

    BookDto toDto(Book book);

    Book fromDto(BookDto book);
}
