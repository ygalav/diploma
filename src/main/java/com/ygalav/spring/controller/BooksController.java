package com.ygalav.spring.controller;

/**
 * Created by tania on 04.03.15.
 */
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







