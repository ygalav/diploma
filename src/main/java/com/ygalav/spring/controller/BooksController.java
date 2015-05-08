package com.ygalav.spring.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.ygalav.spring.dto.BookDto;
import com.ygalav.spring.dto.StudentDto;
import com.ygalav.spring.entity.Book;
import com.ygalav.spring.facade.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping(value = "/books")
public class BooksController {

    @Autowired
    private BookFacade bookFacade;

    @RequestMapping("/")
    public String showBooksHomePage(Model modBook) {
        BookDto bookDto = new BookDto();
        modBook.addAttribute("bookDto", bookDto);
        modBook.addAttribute("books", bookFacade.findAll());
        return "booksHome";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String save(@ModelAttribute BookDto bookDto) {
        bookFacade.save(bookDto);
        return "redirect:/books/";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@ModelAttribute BookDto bookDto, Model model) {
        BookDto emptyBookDto = new BookDto();
        model.addAttribute("bookDto", emptyBookDto);
        List<BookDto> bookDtos = bookFacade.findAll();

        Stream<BookDto> bookDtoStream = bookDtos.stream();
        if (bookDto.getName() != null && !"".equals(bookDto.getName())) {
            bookDtoStream = bookDtoStream.filter(new Predicate<BookDto>() {
                @Override
                public boolean test(BookDto dto) {
                    return dto.getName().contains(bookDto.getName());
                }
            });
        }
        if (bookDto.getAuthor() != null && !"".equals(bookDto.getAuthor())) {
            bookDtoStream = bookDtoStream.filter(new Predicate<BookDto>() {
                @Override
                public boolean test(BookDto dto) {
                    return dto.getAuthor().contains(bookDto.getAuthor());
                }
            });
        }
        model.addAttribute("books", bookDtoStream.collect(Collectors.toList()));
        return "booksHome";
    }
}






