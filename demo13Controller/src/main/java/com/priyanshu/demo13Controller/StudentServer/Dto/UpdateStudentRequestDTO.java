package com.priyanshu.demo13Controller.StudentServer.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentRequestDTO {
    private String name;
    private String email;
    private int age;
}
