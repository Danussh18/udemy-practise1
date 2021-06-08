package com.example.udemypractise1.Service;

import com.example.udemypractise1.Model.Student;
import com.example.udemypractise1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void saveAll(Student student) {
        System.out.println("----------------Inside saveAll Method-----------");
        studentRepository.save(student);
    }

    public Student getById(int id) {
        Student student =studentRepository.findAllById(id);
        return student;
    }
}
