package com.abit.spring.dto;

import com.abit.spring.entity.Role;
import com.abit.spring.validator.UserInfo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo
public class UserCreateEditDto {
    @Email
    String username;
    @Size(min = 3, max = 30)
    String firstname;
    String lastname;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    LocalDate birthDate;
    @NotNull
    Role role;
    Integer companyId;
    MultipartFile image;
}