package com.priyanshu.demo13Controller.StudentServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

     @PostMapping("/create")
    public ResponseEntity<Student> storeStudent(@RequestBody Student student){
        // return student.toString();
        Student result = studentService.studentValidateAndSave(student);  //Using service to validate and save the student
        
        if(result == null){
            ResponseEntity.status(400).body("Student information is invalid");
        }

        return ResponseEntity.status(201).body(result);
    }
}
