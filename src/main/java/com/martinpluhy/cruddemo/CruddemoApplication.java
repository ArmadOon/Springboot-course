package com.martinpluhy.cruddemo;

import com.martinpluhy.cruddemo.dao.StudentDAO;
import com.martinpluhy.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            // createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
            // queryForStudents(studentDAO);
            // queryForStudentsByLastName(studentDAO, "Babica");
            // updateStudent(studentDAO,1,"Johnathan");
            // removeStudent(studentDAO,2);
            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("deleted row count: "+ numRowsDeleted);
    }

    private void updateStudent(StudentDAO studentDAO, int studentId, String firstName) {
        //retrieve student based on the id: primary key
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);
        // change first name to "Scooby"
        System.out.println("Updating student...");
        myStudent.setFirstName(firstName);
        // update the student
        studentDAO.update(myStudent);
        // display updated student

        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO,String lastName) {
        List<Student> theStudents = studentDAO.findByLastName(lastName);

        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }


    }
    private void removeStudent(StudentDAO studentDAO, int id){

        System.out.println("Removing student " + id);
        studentDAO.delete(id);

    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get list of students
        List<Student> theStudents = studentDAO.findAll();
        //display list of students

        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        //create multiple student
        System.out.println("Creating 3 new student objects...");
        Student tempStudent1 = new Student("John", "Doe", "doe@email.com");
        Student tempStudent2 = new Student("Thomas", "Shelby", "shelby@email.com");
        Student tempStudent3 = new Student("Jiri", "Babica", "babica@email.com");
        // save student object
        System.out.println("Saving the students");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Kristyna", "Pluhar", "martin@email.com");
        //save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);
        //display id of the saved student
        System.out.println("Student saved. Generated id: " + tempStudent.getId());
    }

    private void readStudent(StudentDAO studentDAO) {
        // create student object
        System.out.println("Creating new student object");
        Student tempStudent = new Student("Zruda", "Zmrd", "zruda@luv2code.com");
        // save student
        System.out.println("Saving the student..");
        studentDAO.save(tempStudent);
        //display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Student saved. Generated id: " + theId);

        //retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);
        //display student

        System.out.println("Found the student: " + myStudent);
    }

}
