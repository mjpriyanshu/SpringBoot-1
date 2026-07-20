package com.priyanshu.demo13Controller.StudentServer.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponseDTO {
    private int id;
    private String name;
    private int age;
    private String department;

    /*Not need */
    // private LocalDateTime createdAt;
    // private LocalDateTime updatedAt;
}
