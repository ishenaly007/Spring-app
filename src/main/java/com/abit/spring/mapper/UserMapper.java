package com.abit.spring.mapper;

import com.abit.spring.dto.UserReadDto;
import com.abit.spring.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//@RequiredArgsConstructor
//@ToString
//public class UserMapper implements Mapper<User, UserReadDto> {
//
//    @Override
//    public UserReadDto map(User obj) {
//        return new UserReadDto(obj.getId(),
//                obj.getUsername(),
//                obj.getFirstname(),
//                obj.getLastname(),
//                obj.getBirthDate(),
//                obj.getRole(),
//                new CompanyReadMapper().map(obj.getCompany())
//        );
//    }
//}