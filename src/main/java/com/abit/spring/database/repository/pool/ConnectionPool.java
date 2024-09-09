package com.abit.spring.database.repository.pool;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class ConnectionPool {
    private String username;
    private String password;
    private String url;
    private Integer poolSize;

    public ConnectionPool(@Value("${db.username}") String username,
                          @Value("${db.password}") String password,
                          @Value("${db.url}") String url,
                          @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.poolSize = poolSize;
    }
}