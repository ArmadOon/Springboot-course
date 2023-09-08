package com.martinpluhy.demo.rest;

import com.martinpluhy.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student(1, "Martin", "Pluhar"));
        theStudents.add(new Student(2, "Kristyna", "Chrastilova"));
        theStudents.add(new Student(3, "Jiri", "Babica"));
    }



    @GetMapping("/students")
    public List<Student> getStudents() {


        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        return theStudents.get(studentId);
    }
}
