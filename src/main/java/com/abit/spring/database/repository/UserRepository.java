package com.abit.spring.database.repository;

import com.abit.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByFirstnameAndLastnameContainingIgnoringCase(String firstname, String lastname);
}