package com.ygalav.spring.entity.builder;

import com.ygalav.spring.dto.BookDto;

public class BookDtoBuilder {
    private Integer id;
    private String name;
    private String author;
    private String code;

    public  BookDtoBuilder setId(Integer id){
        this.id=id;
        return this;
    }

    public BookDtoBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public BookDtoBuilder setAuthor(String author){
        this.author=author;
        return this;
    }
    public BookDtoBuilder setCode(String code){
        this.code=code;
        return this;
    }
    public BookDto createBookDto(){return new BookDto(id,name,author,code);}
}
