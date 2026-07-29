package com.priyanshu.demo13Controller.StudentServiceTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.priyanshu.demo13Controller.StudentServer.Dto.CreateStudentRequestDTO;
import com.priyanshu.demo13Controller.StudentServer.Entity.Student;
import com.priyanshu.demo13Controller.StudentServer.Service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional //Prevents test data from polluting your real database
public class StudentServiceTest {

    @Autowired
    private StudentService studentservice; // Spring injects this with a real repository

    @Test
    public void testCreateAndGetStudent() { 
        // 1. Arrange
        CreateStudentRequestDTO request = new CreateStudentRequestDTO();
        request.setName("Priyanshu");
        request.setEmail("priyanshu11@gmail.com");
        request.setAge(20);
        request.setDepartment("CSE");

        // 2. Act
        var response = studentservice.createStudent(request);
        Student student = studentservice.getStudentById(response.getId());

        // 3. Assert (Check 'student' from DB, not 'request')
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(student);
        Assertions.assertEquals("Priyanshu", student.getName());
        Assertions.assertEquals("priyanshu11@gmail.com", student.getEmail());
        Assertions.assertEquals(20, student.getAge());
        Assertions.assertEquals("CSE", student.getDepartment());
    }
}
