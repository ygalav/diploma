package com.ygalav.spring.entity.builder;

import com.ygalav.spring.entity.Group;
import com.ygalav.spring.entity.Student;

public class StudentBuilder {
    private String name;
    private String surname;
    private Group studentGroup;
    private String email;
    private String phone;

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public StudentBuilder setStudentGroup(Group studentGroup) {
        this.studentGroup = studentGroup;
        return this;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Student createStudent() {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setStudentGroup(studentGroup);
        student.setPhone(phone);
        student.setEmail(email);
        return new Student();
        
    }
}