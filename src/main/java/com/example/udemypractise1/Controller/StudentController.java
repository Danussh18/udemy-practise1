package com.example.udemypractise1.Controller;

import com.example.udemypractise1.Model.Student;
import com.example.udemypractise1.Request.InQueryRequest;
import com.example.udemypractise1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    @Value("${app.name}")
    String name;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get")
    public String getStudent(){
        return "Hello Student "+name;
    }

    @GetMapping("/getRandomObj")
    public Student getStudentObject(){
        Student student = Student.builder()
                .fname("Surya")
                .lname("Garlapati")
                .email("surya@gmail.com")
                .build();
        studentService.saveAll(student);
        return student;
    }

    @GetMapping("/getStudentById")
    public Student getStudentById(@RequestParam("id") int id){
        return studentService.getById(id);
    }

    @GetMapping("/GetAllStudents")
    public List<Student> getAllStudents(){
        List<Student> l =  studentService.getAll();
        l.forEach(System.out::println);
        return l;
    }

    @PostMapping("/Add")
    public Student AddAStudent(@RequestBody Student student){
        studentService.saveAll(student);
        return student;
    }

    @PutMapping("Modify")
    public Student ModifyAStudent(@RequestBody Student student){
        return studentService.modify(student);
    }

    @DeleteMapping("/Delete")
    public String DeleteAStudent(@RequestParam int id){
        return studentService.delete(id);
    }

    //Get Records By Particular Column
    @GetMapping("/getByFirstName")
    public List<Student> GetByFirstName(@RequestParam("fname") String name){
        return studentService.getByFirstName(name);
    }

    //Get Record by FirstName AND LastName
    @GetMapping("/getByAND")
    public Student GetByFirstNameANDLastName(@RequestParam("fname") String Fname, @RequestParam("lname") String Lname){
        return studentService.getByFirstNameAndLastName(Fname,Lname);
    }

    //Get Record by FirstName OR LastName
    @GetMapping("/getByOR")
    public List<Student> GetByFirstNameORLastName(@RequestParam("fname") String Fname, @RequestParam("lname") String Lname){
        return studentService.getByFirstNameOrLastName(Fname,Lname);
    }

    //Get Records using IN Operator
    @GetMapping("getByIN")
    public List<Student> GetByFirstNameIn(@RequestBody InQueryRequest inQueryRequest){
        return studentService.getByFirstNameIN(inQueryRequest);
    }

    //Using Pagination
    @GetMapping("getAllWithPagination")
    public List<Student> GetWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return  studentService.getAllStudentsWithPagination(pageNo,pageSize);
    }

    //Using Sort
    @GetMapping("getAllWithSorting")
    public List<Student> GetWithSorting(){
        return studentService.getAllStudentsWithSorting();
    }
}
