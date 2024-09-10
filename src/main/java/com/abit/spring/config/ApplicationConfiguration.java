package com.abit.spring.config;

import com.abit.spring.database.repository.UserRepository;
import com.abit.spring.database.repository.pool.ConnectionPool;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ConnectionPool connectionPool() {
        return new ConnectionPool("asa", "asas", "url", 12);
    }

    @Bean
    public ConnectionPool connectionPool1() {
        return new ConnectionPool("asa2", "asas", "url", 12);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    @Profile("prod&web")
    public UserRepository userRepository() {
        return new UserRepository(connectionPool1());
    }
}