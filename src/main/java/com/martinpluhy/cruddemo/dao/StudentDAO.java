package com.martinpluhy.cruddemo.dao;
import com.martinpluhy.cruddemo.entity.Student;
public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
