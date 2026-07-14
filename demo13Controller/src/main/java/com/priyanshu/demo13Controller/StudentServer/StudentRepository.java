package com.priyanshu.demo13Controller.StudentServer;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public String save(Student student){
        System.out.println("Student saved: " + student.toString());
        return "Student saved successfully";
    }
}
