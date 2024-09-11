package com.abit.spring.database.repository.pool;

import jakarta.annotation.PostConstruct;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
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

    @PostConstruct
    public void init() {
        log.info("init connection pool");
    }
}