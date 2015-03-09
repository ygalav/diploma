package com.ygalav.spring.controller;

import com.ygalav.spring.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/books")
public class BooksController {
    @RequestMapping("/")
    public String showBooksHomePage(Model modBook) {
         Book book1 = new Book();
        book1.setId(4);
        book1.setName("Філософія");
        book1.setAuthor("Надольний І.Ф.");
        book1.setCode("20168");
        Book book2 = new Book();
        book2.setId(4);
        book2.setName("Комп'ютерна схемотехніка");
        book2.setAuthor("Бідасюк М.А.");
        book2.setCode("34562");
        ArrayList bookList= new ArrayList();
        bookList.add(book1);
        bookList.add(book2);
        modBook.addAttribute("spysokBook",bookList);
        return "booksHome";
    }
}






