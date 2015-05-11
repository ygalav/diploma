package com.ygalav.spring.controller;

import com.ygalav.spring.dto.RegistrationDto;
import com.ygalav.spring.dto.StudentDto;
import com.ygalav.spring.entity.Student;
import com.ygalav.spring.entity.builder.StudentBuilder;
import com.ygalav.spring.entity.builder.StudentDtoBuilder;
import com.ygalav.spring.facade.GroupFacade;
import com.ygalav.spring.facade.RegistrationFacade;
import com.ygalav.spring.facade.StudentFacade;
import com.ygalav.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentFacade studentFacade;
    @Autowired
    private GroupFacade groupFacade;
    @Autowired
    private RegistrationFacade registrationFacade;

    @RequestMapping("/")
    public String showStudentsHomePage(Model a2){
        a2.addAttribute("studentDto", new StudentDto());
        a2.addAttribute("students", studentFacade.findAll());
        a2.addAttribute("groups",groupFacade.findAll());


       return "studentsHome";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String save(@ModelAttribute StudentDto studentDto){
        studentFacade.save(studentDto);
        return "redirect:/students/";
    }
    @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    public String seem(@PathVariable(value = "id") Integer studentId, Model model) {
        model.addAttribute("student", studentFacade.findOne(studentId));
        List<RegistrationDto> registrationDtoList = registrationFacade.findByStudentId(studentId);
        model.addAttribute("studentRegistrations", registrationDtoList);
        return "studentDetailsPage";
    }
}
