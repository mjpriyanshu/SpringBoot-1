package com.priyanshu.demo13Controller.Server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello, world! From Demo13Controller Springboot";
    }
}