package com.abit.integration.service;

import com.abit.annotation.IT;
import com.abit.spring.database.repository.CompanyRepository;
import com.abit.spring.dto.CompanyDto;
import com.abit.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestConstructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@ExtendWith(SpringExtension.class) //расширение для тестов
//@ContextConfiguration(classes = ApplicationRunner.class) //контекст откуда брать бины
//оба не нужны, ведь они уже есть в
@IT
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyServiceIT {
    private static final Integer COMPANY_ID = 1;

    private final CompanyRepository companyRepository;
    private final CompanyService companyService;

    @Test
    void findById() {
        var actualResult = companyService.findCompanyReadById2(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = CompanyDto.builder().id(COMPANY_ID).build();

        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}