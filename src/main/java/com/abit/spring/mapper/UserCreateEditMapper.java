package com.abit.spring.mapper;

import com.abit.spring.database.repository.CompanyRepository;
import com.abit.spring.dto.UserCreateEditDto;
import com.abit.spring.entity.Company;
import com.abit.spring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {
    private final CompanyRepository companyRepository;

    @Override
    public User map(UserCreateEditDto fromObj, User toObj) {
        copy(fromObj, toObj);
        return toObj;
    }

    @Override
    public User map(UserCreateEditDto obj) {
        User user = new User();
        copy(obj, user);
        return user;
    }

    private void copy(UserCreateEditDto obj, User user) {
        user.setUsername(obj.getUsername());
        user.setFirstname(obj.getFirstname());
        user.setLastname(obj.getLastname());
        user.setBirthDate(obj.getBirthDate());
        user.setRole(obj.getRole());
        user.setCompany(getCompany(obj.getCompanyId()));
    }

    private Company getCompany(Integer companyId) {
        return Optional.ofNullable(companyId)
                .flatMap(companyRepository::findById).orElse(null);
    }
}