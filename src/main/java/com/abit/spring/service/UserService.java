package com.abit.spring.service;

import com.abit.spring.database.repository.Repository;
import com.abit.spring.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@ToString
@Service
public class UserService {
    @Qualifier("userRepository")
    private final Repository<User> repository;

    public User findUserById(int id) {
        return repository.findById(id);
    }
}