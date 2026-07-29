package com.priyanshu.demo13Controller.StudentServiceTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.priyanshu.demo13Controller.StudentServer.Dto.CreateStudentRequestDTO;
import com.priyanshu.demo13Controller.StudentServer.Entity.Student;
import com.priyanshu.demo13Controller.StudentServer.Service.StudentService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@SpringBootTest
public class StudentServiceTest {

    @Autowired
     private StudentService studentservice;   // Create an instance of StudentService with a null StudentRepository for testing purposes.

    @Test
    public void testGetAllStudents() {
        // Call the getAllStudents method and assert the expected behavior.
        // You can use assertions to check the returned list of students.

        CreateStudentRequestDTO student1 = new CreateStudentRequestDTO();
        student1.setName("Priyanshu");
        student1.setEmail("priyanshu11@gmail.com");
        student1.setAge(20);
        student1.setDepartment("CSE");

        var response = studentservice.createStudent(student1);
        Student student = studentservice.getStudentById(response.getId());
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(student);

        Assertions.assertNotNull(student);
        Assertions.assertEquals("Priyanshu", student1.getName());
        Assertions.assertEquals("priyanshu11@gmail.com", student1.getEmail());
        Assertions.assertEquals(20, student1.getAge());
        Assertions.assertEquals("CSE", student1.getDepartment());
    }
}
