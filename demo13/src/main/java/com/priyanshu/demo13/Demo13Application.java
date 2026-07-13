package com.priyanshu.demo13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo13Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo13Application.class, args);

		Student student = new Student("Priyanshu", 22);
		System.out.println("Student Name: " + student.getName());
		System.out.println("Student Age: " + student.getAge());
	}

}
