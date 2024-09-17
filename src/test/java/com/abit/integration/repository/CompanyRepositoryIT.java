package com.abit.integration.repository;

import com.abit.annotation.IT;
import com.abit.spring.database.repository.CompanyRepository;
import com.abit.spring.entity.Company;
import jakarta.persistence.EntityManager;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT //поскольку внутри этой аннотаций есть SpringBootTest, а таем и его контекст
// и так как мы написали эту аннотацию

public class CompanyRepositoryIT {

    private static final Integer COMPANY_ID = 6;
    private final EntityManager entityManager; // сюда автоматичски подставится его обьект(если бы)
    private final CompanyRepository companyRepository;

    public CompanyRepositoryIT(@Autowired EntityManager entityManager, @Autowired CompanyRepository companyRepository) {
        this.entityManager = entityManager;
        this.companyRepository = companyRepository;
    }

    @Test
    void delete() {
        var maybeCompany = companyRepository.findById(COMPANY_ID);
        assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(COMPANY_ID).isEmpty());

    }

    @Test
    void findById() {
        var company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    void save() {
        var company = Company.builder()
                .name("Apple")
                .locales(Map.of(
                        "ru", "Описание для Apple",
                        "en", "Description for Apple"))
                .build();
        entityManager.persist(company);
    }

    @Test
    void findByNameFragment(){
        var company = companyRepository.findAllByNameContainingIgnoreCase("Comp");
        assertNotNull(company);
        System.out.println(company);
    }

    @Test
    void findByName(){
        var company = companyRepository.findByName("Company A");

        System.out.println(company);
    }
}