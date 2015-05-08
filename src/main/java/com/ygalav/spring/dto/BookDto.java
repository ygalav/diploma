package com.ygalav.spring.dto;


public class BookDto {

    private Integer id;
    private String name;
    private String author;
    private String code;

    public BookDto(Integer id, String name, String author, String code) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.code = code;
    }

    public BookDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {this.author = author;}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



}


