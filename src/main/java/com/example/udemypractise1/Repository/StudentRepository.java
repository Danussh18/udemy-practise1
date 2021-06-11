package com.example.udemypractise1.Repository;

import com.example.udemypractise1.Model.Student;
import com.example.udemypractise1.Request.InQueryRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findAllById(int id);
    List<Student> findByFname(String name);
    Student findByFnameAndLname(String fname,String lname);
    List<Student> findByFnameOrLname(String fname, String lname);
    List<Student> findByFnameIn(List<String> fname);
    List<Student> findByFnameContains(String fName);
    List<Student> findByFnameStartsWith(String fName);

    // Method-1
//    @Query("from Student where fname=:FirstName and lname= :LastName")
//    Student getByLastNameANDFirstName(@Param("FirstName") String fName,@Param("LastName") String lName);

    //Method-2
    @Query("from Student where lname=?2 and fname= ?1")
    Student getByLastNameANDFirstName( String fName,String lName);

    @Modifying
    @Transactional
    @Query("Update Student set fname=?2 where id = ?1")
    Integer updateFName(int id,String firstName);
}
