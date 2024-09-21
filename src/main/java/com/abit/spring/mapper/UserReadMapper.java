package com.abit.spring.mapper;

import com.abit.spring.dto.CompanyDto;
import com.abit.spring.dto.UserReadDto;
import com.abit.spring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User obj) {
        CompanyDto company = Optional.ofNullable(obj.getCompany()).map(companyReadMapper::map).orElse(null);
        return new UserReadDto(
                obj.getId(),
                obj.getUsername(),
                obj.getFirstname(),
                obj.getLastname(),
                obj.getBirthDate(),
                obj.getRole(),
                company
        );
    }
}