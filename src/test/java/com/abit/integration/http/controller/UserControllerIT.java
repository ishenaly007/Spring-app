package com.abit.integration.http.controller;

import com.abit.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;

import static com.abit.spring.dto.UserCreateEditDto.Fields;
import static com.abit.spring.dto.UserCreateEditDto.Fields.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IT
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@AutoConfigureMockMvc
@WithMockUser(username = "test@gmail.com", password = "test", roles = {"ADMIN", "USER"})
public class UserControllerIT {
    private final MockMvc mockMvc;

    @Test
        //можно так же над уровнем метода ставить mock юзера
    void findAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/users"))
                .andExpect(model().attributeExists("users"));
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/users")
                        .param(username, "test@gmail.com")
                        .param(firstname, "Ishenaly")
                        .param(lastname, "Narkozuev")
                        .param(birthDate, "01.01.2024")
                        .param(role, "ADMIN")
                        .param(Fields.companyId, "1")
                )
                .andExpectAll(status().is3xxRedirection(),
                        redirectedUrlPattern("/users/{\\d+}"));
    }
}