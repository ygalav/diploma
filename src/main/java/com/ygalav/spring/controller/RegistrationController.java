package com.ygalav.spring.controller;

import com.ygalav.spring.dto.BookDto;
import com.ygalav.spring.dto.RegistrationDto;
import com.ygalav.spring.dto.StudentDto;
import com.ygalav.spring.entity.Registration;
import com.ygalav.spring.facade.BookFacade;
import com.ygalav.spring.facade.RegistrationFacade;
import com.ygalav.spring.facade.StudentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

    @Controller
    @RequestMapping(value = "/registrations")
    public class RegistrationController {
        @Autowired
        private RegistrationFacade registrationFacade;
        @Autowired
        private StudentFacade studentFacade;
        @Autowired
        private BookFacade bookFacade;

        @RequestMapping("/")
        public String showStudentsHomePage(Model model){
            RegistrationDto registrationDto=new RegistrationDto();
            registrationDto.setBook(new BookDto());
            registrationDto.setStudent(new StudentDto());
            model.addAttribute("registrationDto", registrationDto);
            model.addAttribute("registrations", registrationFacade.findAll());
            model.addAttribute("students",studentFacade.findAll());
            model.addAttribute("books",bookFacade.findAll());

            return "registrationHome";
        }

        @RequestMapping(value = "/", method = RequestMethod.POST)
        public String save(@ModelAttribute RegistrationDto registrationDto){
            registrationFacade.save(registrationDto);
            return "redirect:/registrations/";
        }
    }


