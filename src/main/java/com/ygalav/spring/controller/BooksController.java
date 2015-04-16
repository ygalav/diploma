package com.ygalav.spring.controller;

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

@Controller
@RequestMapping(value = "/books")
public class BooksController {

    @Autowired
    private BookFacade bookFacade;

    @RequestMapping("/")
    public String showBooksHomePage(Model modBook) {
        modBook.addAttribute("bookDto", new BookDto());
        modBook.addAttribute("books", bookFacade.findAll());
        return "booksHome";
    }

@RequestMapping(value = "/",method = RequestMethod.POST)
public String save(@ModelAttribute BookDto bookDto) {
    bookFacade.save(bookDto);
    return "redirect:/books/";
}}






