package com.abit.spring.database.repository;

import com.abit.spring.dto.UserFilter;
import com.abit.spring.entity.User;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter userFilter);
}
