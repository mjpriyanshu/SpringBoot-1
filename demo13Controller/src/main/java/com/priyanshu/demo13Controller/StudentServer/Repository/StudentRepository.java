package com.priyanshu.demo13Controller.StudentServer.Repository;

import org.springframework.stereotype.Repository;

import com.priyanshu.demo13Controller.StudentServer.Entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    /*basic check method */
    // public String save(Student student){
        // System.out.println("Student saved: " + student.toString());
        // return "Student saved successfully";
    // }



}
