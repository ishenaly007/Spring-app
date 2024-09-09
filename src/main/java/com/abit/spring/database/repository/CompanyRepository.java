package com.abit.spring.database.repository;

import com.abit.spring.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class CompanyRepository implements Repository<Company> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CompanyRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Company> findById2(int id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "SELECT * FROM company WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Company(rs.getInt("id"), rs.getString("name"))
        ));
    }

    @Override
    public Company findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM company WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Company(rs.getInt("id"), rs.getString("name"))
        );
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