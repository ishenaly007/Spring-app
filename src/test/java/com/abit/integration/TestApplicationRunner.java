package com.abit.integration;

import com.abit.spring.database.repository.pool.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;

@TestConfiguration
public class TestApplicationRunner {

    @SpyBean(name = "connectionPool")
    private ConnectionPool connectionPool;
}
