package com.abit.integration.service;

import com.abit.annotation.IT;
import com.abit.spring.dto.UserCreateEditDto;
import com.abit.spring.dto.UserReadDto;
import com.abit.spring.entity.Role;
import com.abit.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
//по умолчанию политика rollback  то есть бд менятся не будет, чтобы менялась нужно поставить @Commit
public class UserServiceIT {
    private final UserService userService;

    @Test
    void findAll() {
        List<UserReadDto> users = userService.findAll();
        System.out.println(users);
        assertThat(users).hasSize(3);
    }

    @Test
    void findById() {
        UserReadDto user = Optional.ofNullable(userService.findById(2)).get().get();
        System.out.println(user);
        assertThat(user).isNotNull();
    }

    @Test
    void create() {
        UserCreateEditDto userDto = new UserCreateEditDto(
                "Asas",
                "test",
                "Asasa",
                "Asasas",
                LocalDate.now(),
                Role.ADMIN,
                1,
                new MockMultipartFile("test", new byte[0])

        );
        UserReadDto actual = userService.createUser(userDto);
        assertEquals(userDto.getUsername(), actual.getUsername());
        assertEquals(userDto.getFirstname(), actual.getFirstname());
        assertEquals(userDto.getLastname(), actual.getLastname());
        assertEquals(userDto.getBirthDate(), actual.getBirthDate());
        assertEquals(userDto.getCompanyId(), actual.getCompany().getId());
        assertSame(userDto.getRole(), actual.getRole());
    }

    @Test
    void update() {

        Integer userId = 2;

        UserCreateEditDto updatedUserDto = new UserCreateEditDto(
                "UpdatedUsername",
                "testUpd",
                "UpdatedFirstname",
                "UpdatedLastname",
                LocalDate.of(1990, 1, 1),
                Role.USER,
                1,
                new MockMultipartFile("test", new byte[0])
        );
        Optional<UserReadDto> updatedUserOptional = userService.updateUser(userId, updatedUserDto);
        System.out.println("updated1 " + updatedUserOptional);

        assertThat(updatedUserOptional).isPresent();
        UserReadDto updatedUser = updatedUserOptional.get();
        System.out.println("updated2 " + updatedUser);


        assertEquals(updatedUserDto.getUsername(), updatedUser.getUsername());
        assertEquals(updatedUserDto.getFirstname(), updatedUser.getFirstname());
        assertEquals(updatedUserDto.getLastname(), updatedUser.getLastname());
        assertEquals(updatedUserDto.getBirthDate(), updatedUser.getBirthDate());
        assertEquals(updatedUserDto.getCompanyId(), updatedUser.getCompany().getId());
        assertSame(updatedUserDto.getRole(), updatedUser.getRole());
    }

    @Test
    void delete() {
        Integer userId = 2;
        assertFalse(userService.deleteUser(-124));
        assertTrue(userService.deleteUser(userId));
    }
}