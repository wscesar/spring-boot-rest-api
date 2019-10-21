package com.siqueira.springdemo.dao;

import com.siqueira.springdemo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDao {

    private final Map<UUID, Student> database;


    public FakeStudentDaoImpl() {
        database = new HashMap<>();

        UUID id = UUID.randomUUID();

        Student student = new Student(id, 22, "William", "Siqueira", "Computer Science");

        database.put(id, student);
    }

    @Override
    public int insertStudent(UUID id, Student student) {
        database.put(id, student);
        return 1;
    }

    @Override
    public Student selectStudent(UUID id) {
        return database.get(id);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudent(UUID id, Student student) {
        database.put(id, student);
        return 1;
    }

    @Override
    public int deleteStudent(UUID id) {
        database.remove(id);
        return 1;
    }
}
