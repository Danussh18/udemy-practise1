package com.example.udemypractise1.Service;

import com.example.udemypractise1.Model.Address;
import com.example.udemypractise1.Model.Student;
import com.example.udemypractise1.Repository.AddressRepository;
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
    AddressRepository addressRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student saveAll(Student student) {
        System.out.println("----------------Inside saveAll Method-----------");
        Address address = Address.builder().city(student.getAddress().getCity()).street(student.getAddress().getStreet()).build();
        address = addressRepository.save(address);
        student.setAddress(address);

        return studentRepository.save(student);
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

    public List<Student> like(String fName) {
        return studentRepository.findByFnameContains(fName);
    }

    public List<Student> getByStart(String fName) {
        return studentRepository.findByFnameStartsWith(fName);
    }

    public Student getBySelectJPQl(String fname, String lname) {
        return studentRepository.getByLastNameANDFirstName(fname,lname);
    }

    public int updateWithJPQL(int id, String firstName) {
        return studentRepository.updateFName(id,firstName);
    }

    public Integer deleteByFnameJPQL(String fname) {
        return studentRepository.deleteByFnameJPQL(fname);
    }

    public List<Student> getByStudentsSameCity(String city) {
        return studentRepository.getByAddressCity(city);
    }
}
