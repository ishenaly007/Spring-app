package com.abit.spring.config;

import com.abit.spring.database.repository.UserRepository;
import com.abit.spring.database.repository.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@ImportResource("classpath:application.xml")
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.abit.spring")
public class ApplicationConfiguration {
    @Value("${db.driver}")
    private String driver;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public ConnectionPool connectionPool(){
        return new ConnectionPool("asa", "asas", "url", 12);
    }
    @Bean
    public ConnectionPool connectionPool1(){
        return new ConnectionPool("asa2", "asas", "url", 12);
    }

    /*@Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public UserRepository userRepository() {
        return new UserRepository(connectionPool1());
    }*/
}