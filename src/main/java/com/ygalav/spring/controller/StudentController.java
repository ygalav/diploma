package com.ygalav.spring.controller;

import com.ygalav.spring.dto.StudentDto;
import com.ygalav.spring.entity.Student;
import com.ygalav.spring.entity.builder.StudentBuilder;
import com.ygalav.spring.entity.builder.StudentDtoBuilder;
import com.ygalav.spring.facade.StudentFacade;
import com.ygalav.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentFacade studentFacade;

    @RequestMapping("/")
    public String showStudentsHomePage(Model a2){
        StudentDto student1 = new StudentDtoBuilder()
            .setName("Роксолана")
            .setSurname("Іванів")
            .setEmail("roksoliana@gmail.com")
            .setPhone("0669877845")
            .createStudentDto();
        
        StudentDto student2 = new StudentDtoBuilder()
            .setSurname("Онищук")
            .setName("Василь")
            .setEmail("vasyl24@gmail.com")
            .setPhone("0953451234").createStudentDto();

        studentFacade.save(student1);
        studentFacade.save(student2);
        

        a2.addAttribute("student3", studentFacade.findAll());

       return "studentsHome";
    }
}
