package com.ygalav.spring.facade.impl;

import com.ygalav.spring.dto.StudentDto;
import com.ygalav.spring.entity.Group;
import com.ygalav.spring.entity.Student;
import com.ygalav.spring.entity.builder.StudentDtoBuilder;
import com.ygalav.spring.facade.StudentFacade;
import com.ygalav.spring.service.GroupService;
import com.ygalav.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentFacadeImpl implements StudentFacade {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = fromDto(studentDto);
        student = studentService.save(student);
        studentDto.setId(student.getId());
        return studentDto;
    }

    @Override
    public List<StudentDto> findAll() {
        return studentService.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }
    
    @Override
    public Student fromDto(StudentDto studentDto){
        String groupName = studentDto.getStudentGroupName();
        Group group = null;
        if (groupName!=null && groupName.length() > 0){
            group = groupService.findByName(groupName);
        }
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setPhone(studentDto.getPhone());
        student.setEmail(studentDto.getEmail());
        student.setStudentGroup(group);
        return student;
    }
    @Override
    public StudentDto toDto(Student student){
        StudentDto dto = new StudentDtoBuilder().createStudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setSurname(student.getSurname());
        dto.setEmail(student.getEmail());
        dto.setPhone(student.getPhone());
        Group group = student.getStudentGroup();
        dto.setStudentGroupName(group != null ? group.getName() : null);
        return dto;
    }
}
