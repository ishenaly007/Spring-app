package com.abit.spring.database.repository;

import com.abit.spring.database.repository.pool.ConnectionPool;
import com.abit.spring.entity.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Setter
@ToString
@org.springframework.stereotype.Repository
public class UserRepository implements Repository<User> {

    @Autowired
    private ConnectionPool connectionPool;
    @Autowired
    private List<ConnectionPool> connectionPools;

    public UserRepository(
            ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.connectionPools = connectionPools;
    }

    @Override
    public Optional<User> findById2(int id) {
        return Optional.empty();
    }

    @Override
    public User findById(int id) {
        //return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?",
                //new Object[]{id}, (rs, rowNum) -> new User(
                        //rs.getInt("id"),
                        //rs.getString("username")));
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}