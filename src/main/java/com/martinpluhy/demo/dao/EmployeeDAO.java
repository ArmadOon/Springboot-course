package com.martinpluhy.demo.dao;

import com.martinpluhy.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
