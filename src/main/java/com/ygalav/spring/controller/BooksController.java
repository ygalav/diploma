package com.ygalav.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value = "/books")
public class BooksController {
    @RequestMapping("/")
    public String showBooksHomePage() {
        return "booksHome";
    }
}







