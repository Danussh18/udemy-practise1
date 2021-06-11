package com.example.udemypractise1.Repository;

import com.example.udemypractise1.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findAllById(int id);

    List<Student> findByFname(String name);
    Student findByFnameAndLname(String fname,String lname);

}
