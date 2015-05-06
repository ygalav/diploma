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

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


        @RequestMapping(value = "/search", method = RequestMethod.POST)
        public String search(@ModelAttribute RegistrationDto registrationDto, Model model){

            RegistrationDto emptyRegistrationDto=new RegistrationDto();
            emptyRegistrationDto.setBook(new BookDto());
            emptyRegistrationDto.setStudent(new StudentDto());
            model.addAttribute("registrationDto", emptyRegistrationDto);

            List<RegistrationDto> registrationDtos = registrationFacade.findAll();
            /*
            * Якщо імя не порожня строчка і не нулл то імя студента має містити ту строчку
            * Якщо прізвище не порожня строчка і не нулл то прізвище студента має містити ту строчку
            * Якщо хоть одне з полів не співпадає то студент не знайдений
            * Якщо поле порожня строчка або нулл, то воно не враховується в пошуку
            *
            * */
            Stream<RegistrationDto> registrationDtoStream = registrationDtos.stream();
            if (registrationDto.getStudent().getName() != null && ! "".equals(registrationDto.getStudent().getName())){
                registrationDtoStream = registrationDtoStream.filter(new Predicate<RegistrationDto>() {
                    @Override
                    public boolean test(RegistrationDto dto) {
                        return dto.getStudent().getName().contains(registrationDto.getStudent().getName());
                    }
                });
            }

            if (registrationDto.getStudent().getSurname() != null && ! "".equals(registrationDto.getStudent().getSurname())){
                registrationDtoStream = registrationDtoStream.filter(new Predicate<RegistrationDto>() {
                    @Override
                    public boolean test(RegistrationDto dto) {
                        return dto.getStudent().getSurname().contains(registrationDto.getStudent().getSurname());
                    }
                });
            }

            model.addAttribute("registrations", registrationDtoStream.collect(Collectors.toList()));
            model.addAttribute("students",studentFacade.findAll());
            model.addAttribute("books",bookFacade.findAll());

            return "registrationHome";
        }
    }


