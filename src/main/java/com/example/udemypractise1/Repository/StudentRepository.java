package com.example.udemypractise1.Repository;

import com.example.udemypractise1.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findAllById(int id);
}
