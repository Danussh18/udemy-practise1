package com.example.udemypractise1.Service;

import com.example.udemypractise1.Model.Student;
import com.example.udemypractise1.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void saveAll(Student student) {
        System.out.println("----------------Inside saveAll Method-----------");
        studentRepository.save(student);
    }

    public Student getById(int id) {
        return studentRepository.findAllById(id);
    }

    public Student modify(Student student) {
        Student oldStudent = getById(student.getId());
        if (student.getLname()!=null)
            oldStudent.setLname(student.getLname());
        if (student.getEmail()!=null)
            oldStudent.setEmail(student.getEmail());
        if (student.getFname()!=null)
            oldStudent.setFname(student.getFname());
        studentRepository.save(oldStudent);
        return student;
    }


    public String delete(int id) {
        studentRepository.deleteById(id);
        return "Successful";
    }

}
