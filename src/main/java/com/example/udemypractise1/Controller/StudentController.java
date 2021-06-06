package com.example.udemypractise1.Controller;

import com.example.udemypractise1.Model.Student;
import com.example.udemypractise1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Value("${app.name}")
    String name;

    @GetMapping("/get")
    public String getStudent(){
        return "Hello Student "+name;
    }

    @GetMapping("/getByObj")
    public Student getStudentObject(){
        Student student = Student.builder()
                .fname("Surya")
                .lname("Garlapati")
                .id(1234)
                .email("surya@gmail.com")
                .build();
        return student;
    }

    @GetMapping("/GetAllStudents")
    public List<Student> getAllStudents(){

        List<Student> l =  studentService.getAll();
        l.stream().forEach( i -> System.out.println(i));
        return l;
    }
}
