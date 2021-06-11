package com.example.udemypractise1.Service;

import com.example.udemypractise1.Model.Student;
import com.example.udemypractise1.Repository.StudentRepository;
import com.example.udemypractise1.Request.InQueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Student> getByFirstName(String name) {
        return studentRepository.findByFname(name);
    }

    public Student getByFirstNameAndLastName(String fname, String lname) {
        return studentRepository.findByFnameAndLname(fname,lname);
    }

    public List<Student> getByFirstNameOrLastName(String fname, String lname) {
        return studentRepository.findByFnameOrLname(fname,lname);
    }

    public List<Student> getByFirstNameIN(InQueryRequest inQueryRequest) {
        return studentRepository.findByFnameIn(inQueryRequest.getFirstNames());
    }

    public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllStudentsWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC,"fname");
        return studentRepository.findAll(sort);
    }
}
