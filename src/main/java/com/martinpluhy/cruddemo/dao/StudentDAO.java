package com.martinpluhy.cruddemo.dao;
import com.martinpluhy.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    void update(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();
    List<Student> findByLastName(String theLastName);
}
