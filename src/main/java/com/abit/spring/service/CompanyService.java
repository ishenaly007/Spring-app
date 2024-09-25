package com.abit.spring.service;

import com.abit.spring.database.repository.CompanyRepository;
import com.abit.spring.dto.CompanyDto;
import com.abit.spring.mapper.CompanyReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyReadMapper companyReadMapper;

    public List<CompanyDto> findAll() {
        return companyRepository.findAll().stream()
                .map(companyReadMapper::map)
                .toList();
    }
}