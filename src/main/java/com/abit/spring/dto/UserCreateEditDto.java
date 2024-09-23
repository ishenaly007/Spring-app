package com.abit.spring.dto;

import com.abit.spring.entity.Role;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {
    String username;
    String firstname;
    String lastname;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    LocalDate birthDate;
    Role role;
    Integer companyId;
}