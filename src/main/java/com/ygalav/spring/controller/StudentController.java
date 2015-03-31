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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentFacade studentFacade;

    @RequestMapping("/")
    public String showStudentsHomePage(Model a2){
        a2.addAttribute("studentDto", new StudentDto());
        a2.addAttribute("students", studentFacade.findAll());

       return "studentsHome";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String save(@ModelAttribute StudentDto studentDto){
        studentFacade.save(studentDto);
        return "redirect:/students/";
    }
}
