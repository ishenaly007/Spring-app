package com.abit.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "db")
public record DataBaseProperties(
        String username,
        String password,
        String url,
        String driver,
        Integer pool,
        Map<String, Object> properties,
        List<PoolProperties> pools
) {
    public record PoolProperties(
            Integer size,
            Integer timeout
    ) {
    }
}