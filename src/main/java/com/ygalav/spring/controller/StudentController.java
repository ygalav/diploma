package com.ygalav.spring.controller;

import com.ygalav.spring.dto.BookDto;
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
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentFacade studentFacade;
    @Autowired
    private RegistrationFacade registrationFacade;
    @Autowired
    private GroupFacade groupFacade;

    @RequestMapping("/")
    public String showStudentsHomePage(Model model){
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("students", studentFacade.findAll());
        model.addAttribute("groups", groupFacade.findAll());
       return "studentsHome";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String save(@ModelAttribute StudentDto studentDto) {
        studentFacade.save(studentDto);
        return "redirect:/students/";
    }
        @RequestMapping(value = "/search", method = RequestMethod.POST)
        public String search(@ModelAttribute StudentDto studentDto, Model  modStud) {
            StudentDto emptyStudentDto = new StudentDto();
            modStud.addAttribute("studentDto", emptyStudentDto);
            List<StudentDto> studentDtos = studentFacade.findAll();

            Stream<StudentDto> studentDtoStream = studentDtos.stream();
            if (studentDto.getStudentGroupName() != null && !"".equals(studentDto.getStudentGroupName())) {
                studentDtoStream = studentDtoStream.filter(new Predicate<StudentDto>() {
                    @Override
                    public boolean test(StudentDto dto) {
                        if(dto.getStudentGroupName()==null){
                            return false;
                        }
                        return dto.getStudentGroupName().contains(studentDto.getStudentGroupName());
                    }
                });
            }
            if (studentDto.getSurname() != null && !"".equals(studentDto.getSurname())) {
                studentDtoStream = studentDtoStream.filter(new Predicate<StudentDto>() {
                    @Override
                    public boolean test(StudentDto dto) {
                        return dto.getSurname().contains(studentDto.getSurname());
                    }
                });
            }
            if (studentDto.getName() != null && !"".equals(studentDto.getName())) {
                studentDtoStream = studentDtoStream.filter(new Predicate<StudentDto>() {
                    @Override
                    public boolean test(StudentDto dto) {
                        return dto.getName().contains(studentDto.getName());
                    }
                });
            }


            modStud.addAttribute("students", studentDtoStream.collect(Collectors.toList()));
            return "studentsHome";
        }

    @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    public String seem(@PathVariable(value = "id") Integer studentId, Model model) {
        model.addAttribute("student", studentFacade.findOne(studentId));
        List<RegistrationDto> registrationDtoList = registrationFacade.findByStudentId(studentId);
        model.addAttribute("studentRegistrations", registrationDtoList);
        return "studentDetailsPage";
    }
}
