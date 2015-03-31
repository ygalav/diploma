package com.ygalav.spring.facade;

import com.ygalav.spring.dto.BookDto;

import java.util.List;

public interface BookFacade {
    List<BookDto> findAll();
    BookDto save(BookDto bookDto);
}
