package com.siqueira.springdemo.dao;

import com.siqueira.springdemo.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {
    int insertStudent(UUID id, Student student);

    Student selectStudent(UUID id);

    List<Student> selectAllStudents();

    int updateStudent(UUID id, Student student);

    int deleteStudent(UUID id);
}
