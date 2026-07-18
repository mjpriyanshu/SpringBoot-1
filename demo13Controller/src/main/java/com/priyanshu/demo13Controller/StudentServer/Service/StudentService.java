package com.priyanshu.demo13Controller.StudentServer.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.priyanshu.demo13Controller.StudentServer.Entity.Student;
import com.priyanshu.demo13Controller.StudentServer.Repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository studentRepository;    // Create ref for StudentRepository class to save into DB

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    private boolean isStudentValid(Student student){
        int id = student.getId();
        String name = student.getName();
        String department = student.getDepartment();
        int age = student.getAge();

        if(id < 0 || name == null || age <0 || department == null){
            return false;
        }
        return true;
    }

    public Student studentSave(Student student) {
        if(!isStudentValid(student)){
            return null;
        }
        if(studentRepository.existsById(student.getId())){
            return null;
        }
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }


    public Student studentUpdateSave(Student student){
        if(!isStudentValid(student)){
            return null;
        }
        student.setUpdatedAt(LocalDateTime.now());
        return studentRepository.save(student);
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
