package com.abit.unit;

import com.abit.spring.database.repository.CompanyRepository;
import com.abit.spring.dto.CompanyDto;
import com.abit.spring.entity.Company;
import com.abit.spring.listener.EntityEvent;
import com.abit.spring.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {
    private static final Integer COMPANY_ID = 1;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private ApplicationEventPublisher publisher;

    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
        Mockito.doReturn(Optional.of(Company.builder()
                        .id(COMPANY_ID)
                        .build()))
                .when(companyRepository).findById2(COMPANY_ID);

        var actualResult = companyService.findCompanyReadById2(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = CompanyDto.builder().id(COMPANY_ID).build();

        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
        verify(publisher).publishEvent(any(EntityEvent.class));
    }
}