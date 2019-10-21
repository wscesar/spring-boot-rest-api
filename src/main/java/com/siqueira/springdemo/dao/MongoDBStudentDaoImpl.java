package com.siqueira.springdemo.dao;

import com.siqueira.springdemo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("mongoDb")
public class MongoDBStudentDaoImpl implements StudentDao {

//    private final MongoDbTemplate
    @Override
    public int insertStudent(UUID id, Student student) {
        return 0;
    }

    @Override
    public Student selectStudent(UUID id) {
        return null;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(
                new Student(UUID.randomUUID(), 18, "Mongo", "Database", "NoSQL")
        );
        return students;
    }

    @Override
    public int updateStudent(UUID id, Student student) {
        return 0;
    }

    @Override
    public int deleteStudent(UUID id) {
        return 0;
    }
}
