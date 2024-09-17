package com.abit.integration.repository;

import com.abit.annotation.IT;
import com.abit.spring.database.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@IT
public class UserRepositoryIT {

    private static final Integer USER_ID = 6;
    private final EntityManager entityManager; // сюда автоматичски подставится его обьект(если бы)
    private final UserRepository userRepository;

    public UserRepositoryIT(@Autowired EntityManager entityManager, @Autowired UserRepository userRepository) {
        this.entityManager = entityManager;
        this.userRepository = userRepository;
    }

    @Test
    void findByFLNameFragment() {
        var users = userRepository.findAllByFirstnameAndLastnameContainingIgnoringCase("a", "i");
        System.out.println(users);
    }
}
