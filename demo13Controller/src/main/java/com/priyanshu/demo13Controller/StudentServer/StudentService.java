package com.priyanshu.demo13Controller.StudentServer;

import org.springframework.stereotype.Service;

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

        studentRepository.save(student);
        return student;
    }
}
