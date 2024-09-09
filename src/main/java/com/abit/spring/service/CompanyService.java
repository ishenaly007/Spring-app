package com.abit.spring.service;

import com.abit.spring.database.repository.Repository;
import com.abit.spring.dto.CompanyDto;
import com.abit.spring.entity.Company;
import com.abit.spring.listener.EntityEvent;
import com.abit.spring.listener.MyAccessType;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    private final Repository<Company> repository;
    private final ApplicationEventPublisher eventPublisher;


    public CompanyService(Repository<Company> repository, ApplicationEventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public Company findCompanyById(int id) {
        return repository.findById(id);
    }

    public Optional<CompanyDto> findCompanyById2(int id) {
        return repository.findById2(id).map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(
                            entity,
                            MyAccessType.READ));
                    return CompanyDto.builder()
                            .name(entity.getName())
                            .build();
                }
        );
    }
}