package com.abit.spring.database.repository;

import com.abit.spring.database.repository.pool.ConnectionPool;
import com.abit.spring.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Repository
public class CompanyRepository implements Repository<Company> {

    @Autowired
    private ConnectionPool connectionPool;

    @Autowired
    public CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Optional<Company> findById2(int id) {
        return Optional.of(new Company(id, "Google"));
    }

    @Override
    public Company findById(int id) {
        //return jdbcTemplate.queryForObject("SELECT * FROM company WHERE id = ?", new Object[]{id}, (rs, rowNum) -> new Company(rs.getInt("id"), rs.getString("name")));
        return null;
    }

    @Override
    public void save(Company obj) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Company findByUsername(String username) {
        return null;
    }
}