package com.priyanshu.demo13Controller.StudentServer.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.priyanshu.demo13Controller.StudentServer.Dto.CreateStudentRequestDTO;
import com.priyanshu.demo13Controller.StudentServer.Dto.StudentResponseDTO;
import com.priyanshu.demo13Controller.StudentServer.Dto.UpdateStudentRequestDTO;
import com.priyanshu.demo13Controller.StudentServer.Entity.Student;
import com.priyanshu.demo13Controller.StudentServer.Repository.StudentRepository;

@Service
public class StudentService {
    /* Create ref for StudentRepository class to save into DB and making dependency immutable so reference never change*/
    private final StudentRepository studentRepository; 

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    /*Done using validation in entity for now */
    // private boolean isStudentValid(Student student){
    // int id = student.getId();
    // String name = student.getName();
    // String department = student.getDepartment();
    // int age = student.getAge();

    // if(id < 0 || name == null || age <0 || department == null){
    // return false;
    // }
    // return true;
    // }


    
    public List<StudentResponseDTO> getAllStudents() {
        // return studentRepository.findAll();

        List<Student> students = studentRepository.findAll();
        List<StudentResponseDTO> response = new ArrayList<>();

        for(Student student : students){
            response.add(mapToResponseDTO(student));
        }
        return response;
    }

    /*Helper Functions */
    private Student findStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);

        /*Optional is never null, so we check empty and throw and error if empty */
        if(student.isEmpty()){
            throw new RuntimeException("Student not found"); // we will get this exception message when we try to get the student by id and it does not exist. This will be handled by GlobalException class.
        }
        return student.get();
    }



    /*Mapper Methods */
    private Student mapToStudent(CreateStudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setDepartment(studentRequestDTO.getDepartment());
        return student;
    }

    private StudentResponseDTO mapToResponseDTO(Student student) {
        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setDepartment(student.getDepartment());
        return responseDTO;
    }


    /*
     * studentSave method.
     * Student Class conversion to CreateStudentRequestDTO
     */

    // public Student studentSave(Student student) {
    // if(!isStudentValid(student)){
    // return null;
    // }
    // if(studentRepository.existsById(student.getId())){
    // return null;
    // }
    // /*We are using the annotation @CreationTimestamp */
    // // student.setCreatedAt(LocalDateTime.now());
    // // student.setUpdatedAt(LocalDateTime.now());
    // return studentRepository.save(student);
    // }

    /* CreateStudentRequestDTO code */
    public StudentResponseDTO createStudent(CreateStudentRequestDTO studentRequestDTO) {
        Student student = mapToStudent(studentRequestDTO);
        Student savedStudent = studentRepository.save(student);
        return mapToResponseDTO(savedStudent);
    }



    /* Conversion from normal to DTO response for getStudentById */
    public Student getStudentById(int id) {
        return findStudentById(id);
    }


    public StudentResponseDTO getStudentDTOById(int id) {

        Student student = findStudentById(id); //helper function
        return mapToResponseDTO(student);
    }



    /* Updatesave conversion below using DTO */
    // public Student studentUpdateSave(Student student){
    // // if(!isStudentValid(student)){
    // // return null;
    // // }
    // /*We are using the annotation @UpdateTimestamp */
    // // student.setUpdatedAt(LocalDateTime.now());
    // return studentRepository.save(student);
    // }

    public StudentResponseDTO updateStudent(int id, UpdateStudentRequestDTO updateStudentRequestDTO) {
        Student student = findStudentById(id); //helper function

        student.setName(updateStudentRequestDTO.getName());
        student.setAge(updateStudentRequestDTO.getAge());

        Student updatedStudent = studentRepository.save(student);
        return mapToResponseDTO(updatedStudent);
    }




    public void deleteStudentById(int id) {
        findStudentById(id); //helper function to check if student exists, then we  can delete it. If not, it will throw an exception and we will not reach the delete line.
        studentRepository.deleteById(id);
    }
}
