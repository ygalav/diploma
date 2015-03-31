package com.ygalav.spring.entity.builder;

import com.ygalav.spring.entity.Book;

public class BookBuilder {
    private Integer id;
    private String name;
    private String author;
    private String code;

    public BookBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BookBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public BookBuilder setAuthor(String author){
        this.author=author;
        return this;
    }
    public BookBuilder setCode(String code){
        this.code=code;
        return this;
    }
    public Book createBook(){
        Book book=new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setCode(code);
        return book;
    }
}
