package com.abit.integration.service;

import com.abit.annotation.IT;
import com.abit.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestConstructor;

@IT
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)

public class UserServiceIT {
    private final UserService userService;

    @Test
    void test() {

    }
}
