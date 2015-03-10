package com.ygalav.spring.entity.builder;

import com.ygalav.spring.dto.StudentDto;

public class StudentDtoBuilder {
    private Integer id;
    private String name;
    private String surname;
    private String studentGroupName;
    private String email;
    private String phone;

    public StudentDtoBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public StudentDtoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentDtoBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public StudentDtoBuilder setStudentGroupName(String studentGroupName) {
        this.studentGroupName = studentGroupName;
        return this;
    }

    public StudentDtoBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentDtoBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public StudentDto createStudentDto() {
        return new StudentDto(id, name, surname, studentGroupName, email, phone);
    }
}