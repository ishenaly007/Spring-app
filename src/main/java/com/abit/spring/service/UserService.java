package com.abit.spring.service;

import com.abit.spring.database.repository.UserRepository;
import com.abit.spring.dto.QPredicates;
import com.abit.spring.dto.UserCreateEditDto;
import com.abit.spring.dto.UserFilter;
import com.abit.spring.dto.UserReadDto;
import com.abit.spring.mapper.UserCreateEditMapper;
import com.abit.spring.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.abit.spring.entity.QUser.user;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserReadMapper userReadMapper;
    private final UserRepository userRepository;
    private final UserCreateEditMapper userCreateEditMapper;

    public Page<UserReadDto> findAllUsers(UserFilter userFilter, Pageable pageable) {
        var predicate = QPredicates.builder()
                .add(userFilter.firstname(), user.firstname::containsIgnoreCase)
                .add(userFilter.lastname(), user.lastname::containsIgnoreCase)
                .add(userFilter.birthDate(), user.birthDate::before).build();
        return userRepository.findAll(predicate, pageable).map(userReadMapper::map);
    }

    public List<UserReadDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .toList();
    }

    public List<UserReadDto> findAllUsers(UserFilter userFilter) {
        return userRepository.findAllByFilter(userFilter).stream()
                .map(userReadMapper::map)
                .toList();
    }

    public Optional<UserReadDto> findUserById(Integer id) {
        return userRepository.findById(id).map(userReadMapper::map);
    }

    @Transactional
    public UserReadDto createUser(UserCreateEditDto userDto) {
        return Optional.of(userDto)
                .map(userCreateEditMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserReadDto> updateUser(Integer id, UserCreateEditDto userDto) {
        return userRepository.findById(id)
                .map(entity -> userCreateEditMapper.map(userDto, entity))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public boolean deleteUser(Integer id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                }).orElse(false);
    }
}