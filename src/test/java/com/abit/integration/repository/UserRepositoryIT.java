package com.abit.integration.repository;

import com.abit.annotation.IT;
import com.abit.spring.database.repository.UserRepository;
import com.abit.spring.entity.Role;
import com.abit.spring.entity.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@IT
public class UserRepositoryIT {

    private static final Integer USER_ID = 6;

    private final EntityManager entityManager; // сюда автоматичски подставится его обьект(если бы)
    private final UserRepository userRepository;

    @Test
    void checkPageable() {
        var pageable = PageRequest.of(1, 2, Sort.by("id"));
        var page = userRepository.findAll(pageable);
        page.forEach(p -> System.out.println(p.getId()));
    }

    @Test
    void findFirstBy() {
        List<User> users = userRepository.findFirstBy(
                Sort.by("id")
                        .and(Sort.by("username")
                        ).descending());
        System.out.println(users);
    }

    @Test
    void checkProjections() {
        var entities =
                userRepository.findAllByCompanyId(1);
        assertEquals(2, entities.size());
    }

    public UserRepositoryIT(@Autowired EntityManager entityManager, @Autowired UserRepository userRepository) {
        this.entityManager = entityManager;
        this.userRepository = userRepository;
    }

    @Test
    void findByFLNameFragment() {
        var users = userRepository.findAllByFirstnameContainingIgnoreCaseAndLastnameContainingIgnoreCase("a", "i");
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println(users);
    }

    @Test
    void updateRole() {
        var user1 = userRepository.findById(2).get();
        assertTrue(Role.ADMIN.equals(user1.getRole()));
        var result = userRepository.updateRole(Role.USER, 2, 3);
        var user11 = userRepository.findById(2).get();
        assertTrue(Role.USER.equals(user11.getRole()));
        assertEquals(2, result);
    }
}
