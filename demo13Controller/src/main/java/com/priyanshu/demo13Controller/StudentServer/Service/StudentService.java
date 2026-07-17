package com.priyanshu.demo13Controller.StudentServer.Service;

import org.springframework.stereotype.Service;

import com.priyanshu.demo13Controller.StudentServer.Entity.Student;
import com.priyanshu.demo13Controller.StudentServer.Repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository studentRepository;    // Create ref for StudentRepository class to save into DB

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student studentValidateAndSave(Student student) {
        int id = student.getId();
        String name = student.getName();
        String department = student.getDepartment();
        int age = student.getAge();

        if(id < 0 || name == null || age <0 || department == null){
            return null;
        }
        
        //if user already exist, then we dont update the same value again with POST
        if(studentRepository.existsById(id)){
            System.out.print("User Already Exist with id: " + id + " Can't Update");
            return null;
        }
        studentRepository.save(student);
        return student;
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
