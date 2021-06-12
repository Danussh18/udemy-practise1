package com.example.udemypractise1.Controller;

import com.example.udemypractise1.Model.Student;
import com.example.udemypractise1.Request.InQueryRequest;
import com.example.udemypractise1.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    StudentService studentService;

    @Value("${app.name}")
    String name;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get")
    public String getStudent(){
        logger.error("Inside Error");
        logger.warn("Inside Error");
        logger.info("Inside Error");
        logger.debug("Inside Error");
        logger.trace("Inside Error");
        return "Hello Student "+name;
    }

    @GetMapping("/getRandomObj")
    public Student getStudentObject(){
//        Student student = Student.builder()
//                .fname("Surya")
//                .lname("Garlapati")
//                .email("surya@gmail.com")
//                .build();
        Student student = new Student("Ratna","Garlapati","ratna@gmail.com");
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
       return studentService.saveAll(student);
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

    //Like %fName%
    @GetMapping("getByLike/{fName}")
    public List<Student> GetByLike(@PathVariable String fName){
        return studentService.like(fName);
    }

    //Like fName%
    @GetMapping("/getByStart/{fName}")
    public List<Student> GetByStart(@PathVariable String fName){
        return studentService.getByStart(fName);
    }

    //GetByFirstNameANDLastName using JPQL
    @GetMapping("/selectJPQL/{fname}/{lname}")
    public Student GetByFirstNameANDLastNameJPQL(@PathVariable String fname,@PathVariable String lname){
        return studentService.getBySelectJPQl(fname,lname);
    }

    //Update using JPQL
    @PutMapping("updateFname/{id}/{firstName}")
    public String updateStudentWithJPQL(@PathVariable int id,@PathVariable String firstName){
        return studentService.updateWithJPQL(id,firstName)+" Updated";
    }

    //Delete using JPQL
    @DeleteMapping("/deleteByfname/{fname}")
    public Integer deleteByID(@PathVariable String fname){
        return studentService.deleteByFnameJPQL(fname);
    }

    @GetMapping("/city/{city}")
    public List<Student> getByCity(@PathVariable String city){
        return studentService.getByStudentsSameCity(city);
    }
}
