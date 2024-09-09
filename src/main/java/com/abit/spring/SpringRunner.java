package com.abit.spring;

import com.abit.spring.config.ApplicationConfiguration;
import com.abit.spring.database.repository.UserRepository;
import com.abit.spring.dto.CompanyDto;
import com.abit.spring.entity.Company;
import com.abit.spring.service.CompanyService;
import com.abit.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        var userRepository = context.getBean(UserRepository.class);
        UserService userService = context.getBean(UserService.class);
        CompanyService companyService = context.getBean(CompanyService.class);
/*
        User user = userService.findUserById(2);
        User user2 = userRepository.findById(3);
        */
        var company = companyService.findCompanyById2(2).get();

        //System.out.println(user2);
        System.out.println(company);
        /*System.out.println("User: " + user);
        System.out.println("Company: " + company);
        context.close();*/
    }
}