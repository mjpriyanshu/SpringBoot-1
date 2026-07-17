package com.priyanshu.demo13Controller.StudentServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.demo13Controller.StudentServer.Entity.Student;
import com.priyanshu.demo13Controller.StudentServer.Service.StudentService;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


     @PostMapping("/create")
    public ResponseEntity<?> storeStudent(@RequestBody Student student){
        // return student.toString();
        Student result = studentService.studentValidateAndSave(student);  //Using service to validate and save the student
        
        if(result == null){
            return ResponseEntity.status(400).body("Student information is invalid");
        }

        return ResponseEntity.status(201).body(result);
    }


    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        if(student == null){
            return ResponseEntity.status(404).body("Student not found with id: " + id);
        }
        return ResponseEntity.status(200).body(student);
    }
}
