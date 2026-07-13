package com.priyanshu.demo13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.priyanshu.demo13.Service.OrderService;

@SpringBootApplication
public class Demo13Application {

	public static void main(String[] args) {
		// SpringApplication.run(Demo13Application.class, args);
		// Student student = new Student("Priyanshu", 22);
		// System.out.println("Student Name: " + student.getName());
		// System.out.println("Student Age: " + student.getAge());

		ApplicationContext context = SpringApplication.run(Demo13Application.class, args);
		// Student student = context.getBean(Student.class);
		// student.setName("Priyanshu");
		// student.setAge(22);
		// System.out.println("Student Name: " + student.getName());
		// System.out.println("Student Age: " + student.getAge());


		OrderService orderService = context.getBean(OrderService.class);
		orderService.order();
	}

}
