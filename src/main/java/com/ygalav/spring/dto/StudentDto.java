package com.ygalav.spring.dto;

public class StudentDto {
    private Integer id;
    private String name;
    private String surname;
    private String studentGroupName;
    private String email;
    private String phone;

    public StudentDto(Integer id, String name, String surname, String studentGroupName, String email, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.studentGroupName = studentGroupName;
        this.email = email;
        this.phone = phone;
    }

    public StudentDto() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudentGroupName() {
        return studentGroupName;
    }

    public void setStudentGroupName(String studentGroupName) {
        this.studentGroupName = studentGroupName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
