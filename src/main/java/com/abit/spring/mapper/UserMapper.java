package com.abit.spring.mapper;

import com.abit.spring.dto.UserDto;
import com.abit.spring.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class UserMapper {
    private final UserDto userDto;

    /*public UserDto mapFrom(User obj) {
        return new UserDto(obj.getId(),
                obj.getUsername(),
                obj.getRole(),
                new CompanyMapper().mapFrom(obj.getCompany())
        );
    }*/
}