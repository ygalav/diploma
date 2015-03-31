package com.ygalav.spring.controller;

import com.ygalav.spring.dto.BookDto;
import com.ygalav.spring.entity.Book;
import com.ygalav.spring.facade.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/books")
public class BooksController {

    @Autowired
    private BookFacade bookFacade;

    @RequestMapping("/")
    public String showBooksHomePage(Model modBook) {
         BookDto book1 = new BookDto();
        book1.setName("Філософія");
        book1.setAuthor("Надольний І.Ф.");
        book1.setCode("20168");
        BookDto book2 = new BookDto();
        book2.setName("Комп'ютерна схемотехніка");
        book2.setAuthor("Бідасюк М.А.");
        book2.setCode("34562");

        bookFacade.save(book1);
        bookFacade.save(book2);
        modBook.addAttribute("spysokBook",bookFacade.findAll());
        return "booksHome";
    }
}






