package com.priyanshu.demo13Controller.StudentServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {

    //1. Store Student Data in Student Class
    @PostMapping("/create")
    public String storeStudent(){
        return """
                id : 1,
                name : Priyanshu,
                Department: CSE,
                age : 21
                """;
    }

    //2. Read Student data with ID

    //3. update the Student information

    ///4. Delete the Student information
}
