package com.priyanshu.demo13Controller.StudentServer.Dto;



import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CreateStudentRequestDTO {
    private String name;
    private String email;
    private String department;
    private int age;
    
    /*We dont need to send these details */
    // private int id;
    // private LocalDateTime createdAt;
    // private LocalDateTime updatedAt;
}
