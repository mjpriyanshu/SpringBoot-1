package com.priyanshu.demo13Controller.StudentServer.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyanshu.demo13Controller.StudentServer.Entity.People;


public interface PeopleRepository extends JpaRepository<People,Integer> {
    Optional<People> findByUsername(String username);
}
