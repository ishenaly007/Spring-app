package com.abit.spring.database.repository;

import java.util.Optional;

public interface Repository<T> {
    Optional<T> findById2(int id);
    T findById(int id);
    void save(T obj);
    void delete(int id);
    T findByUsername(String username);
}