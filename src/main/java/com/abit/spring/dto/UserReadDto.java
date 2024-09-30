package com.abit.spring.dto;

import com.abit.spring.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserReadDto {
    Integer id;
    String username;
    String firstname;
    String lastname;
    LocalDate birthDate;
    Role role;
    String image;
    CompanyDto company;
}