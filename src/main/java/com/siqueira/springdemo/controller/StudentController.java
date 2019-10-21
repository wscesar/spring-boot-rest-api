package com.siqueira.springdemo.controller;

import com.siqueira.springdemo.model.Student;
import com.siqueira.springdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService =  studentService;
    }


    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> selectAllStudents(){
        return studentService.selectAllStudents();
    }


    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public Student selectStudent(@PathVariable("studentId") UUID id){
        return studentService.selectStudent(id);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public int insertStudent(@RequestBody Student student){
        return studentService.insertStudent(UUID.randomUUID(), student);
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public int updateStudent(@PathVariable("studentId") UUID id, @RequestBody Student student){
        student.setId(id);
        return studentService.updateStudent(id, student);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{studentId}"
    )
    public int deleteStudent(@PathVariable("studentId") UUID id){
        return studentService.deleteStudent(id);
    }


}
