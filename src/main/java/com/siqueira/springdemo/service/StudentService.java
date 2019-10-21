package com.siqueira.springdemo.service;

import com.siqueira.springdemo.dao.StudentDao;
import com.siqueira.springdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int insertStudent(UUID id, Student student){
        UUID uuid = id == null ? UUID.randomUUID() : id;
        student.setId(uuid);
        return studentDao.insertStudent(uuid, student);
    }

    public Student selectStudent(UUID id){
        return studentDao.selectStudent(id);
    }

    public List<Student> selectAllStudents(){
        return studentDao.selectAllStudents();
    }

    public int updateStudent(UUID id, Student student){
        return studentDao.updateStudent(id, student);
    }

    public int deleteStudent(UUID id){
        return studentDao.deleteStudent(id);
    }
}
