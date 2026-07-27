package com.priyanshu.demo13Controller.StudentServer.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyanshu.demo13Controller.StudentServer.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}