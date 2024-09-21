package com.abit.spring.dto;

import com.abit.spring.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserCreateEditDto {
    String username;
    String firstname;
    String lastname;
    LocalDate birthDate;
    Role role;
    Integer companyId;
}