package com.abit.spring.service;

import com.abit.spring.database.repository.Repository;
import com.abit.spring.entity.User;
import lombok.ToString;
import org.springframework.stereotype.Service;

@ToString
@Service
public class UserService {

    private final Repository<User> repository;

    public UserService(Repository<User> repository) {
        this.repository = repository;
    }

    public User findUserById(int id) {
        return repository.findById(id);
    }
}