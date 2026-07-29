// package com.priyanshu.demo13Controller.StudentServiceTest;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import com.priyanshu.demo13Controller.StudentServer.Dto.CreateStudentRequestDTO;
// import com.priyanshu.demo13Controller.StudentServer.Entity.Student;
// import com.priyanshu.demo13Controller.StudentServer.Service.StudentService;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.springframework.transaction.annotation.Transactional;

// @SpringBootTest
// @Transactional //Prevents test data from polluting your real database
// public class StudentServiceTest {

//     @Autowired
//     private StudentService studentservice; // Spring injects this with a real repository

//     @Test
//     public void testCreateAndGetStudent() { 
//         // 1. Arrange
//         CreateStudentRequestDTO request = new CreateStudentRequestDTO();
//         request.setName("Priyanshu");
//         request.setEmail("priyanshu11@gmail.com");
//         request.setAge(20);
//         request.setDepartment("CSE");

//         // 2. Act
//         var response = studentservice.createStudent(request);
//         Student student = studentservice.getStudentById(response.getId());

//         // 3. Assert (Check 'student' from DB, not 'request')
//         Assertions.assertNotNull(response);
//         Assertions.assertNotNull(student);
//         Assertions.assertEquals("Priyanshu", student.getName());
//         Assertions.assertEquals("priyanshu11@gmail.com", student.getEmail());
//         Assertions.assertEquals(20, student.getAge());
//         Assertions.assertEquals("CSE", student.getDepartment());
//     }
// }



package com.priyanshu.demo13Controller.StudentServiceTest;

import com.priyanshu.demo13Controller.StudentServer.Entity.Student;
import com.priyanshu.demo13Controller.StudentServer.Repository.StudentRepository;
import com.priyanshu.demo13Controller.StudentServer.Service.StudentService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StudentServiceUnitTest {

    @Mock
    private StudentRepository studentRepository; 

    @InjectMocks
    private StudentService studentService; 

    @Test
    public void testGetStudentById_Success() {
        // 1. Arrange: Use Lombok's @AllArgsConstructor to safely build the entity with an ID.
        // Match the exact field order from your Student Entity class:
        // id, name, email, department, age, createdAt, updatedAt
        Student mockDbStudent = new Student(
            1,                          // id (primitive int)
            "Priyanshu",                // name
            "priyanshu11@gmail.com",    // email
            "CSE",                      // department
            20,                         // age
            LocalDateTime.now(),        // createdAt
            LocalDateTime.now()         // updatedAt
        );

        // Tell Mockito to expect primitive integer 1 (not 1L)
        Mockito.when(studentRepository.findById(1)).thenReturn(Optional.of(mockDbStudent));

        // 2. Act
        Student result = studentService.getStudentById(1);

        // 3. Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("Priyanshu", result.getName());
        Assertions.assertEquals("priyanshu11@gmail.com", result.getEmail());
        
        Mockito.verify(studentRepository, Mockito.times(1)).findById(1);
    }
}
