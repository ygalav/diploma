package com.ygalav.spring.controller;

import com.ygalav.spring.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/students")
public class StudentController {

    @RequestMapping("/")
    public String showStudentsHomePage(Model a2){
        Student student1 = new Student();
        student1.setId(4);
        Student student2 = new Student();
        student1.setId(4);
        ArrayList studList= new ArrayList();
        studList.add(student1);
        studList.add(student2);
        a2.addAttribute("student3",studList);

       return "studentsHome";
    }
}
