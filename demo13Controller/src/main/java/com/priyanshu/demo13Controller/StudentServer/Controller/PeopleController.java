package com.priyanshu.demo13Controller.StudentServer.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.demo13Controller.StudentServer.Entity.People;
import com.priyanshu.demo13Controller.StudentServer.Repository.PeopleRepository;
import com.priyanshu.demo13Controller.StudentServer.Service.JwtService;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PeopleRepository repository;

    @Autowired
    private JwtService jwtService;

    // Signup
    @PostMapping("/signup")
    public String signup(@RequestBody People people) {

        repository.save(people);

        return "User Created Successfully";
    }

    // Login
    @PostMapping("/login")
    public String login(@RequestBody People people) {

        Optional<People> dbUser =
                repository.findByUsername(people.getUsername());

        if(dbUser.isEmpty()) {
            return "User Not Found";
        }

        if(!dbUser.get().getPassword().equals(people.getPassword())) {
            return "Wrong Password";
        }

        String token =
                jwtService.generateToken(people.getUsername());

        return token;
    }

    // Protected API
    @GetMapping("/{id}")
    public Object getPeople(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String authHeader) {

        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            return "JWT Missing";
        }

        String token =
                authHeader.substring(7);

        if(!jwtService.validateToken(token)) {
            return "Invalid Token";
        }

        return repository.findById(id).orElse(null);

    }
}
