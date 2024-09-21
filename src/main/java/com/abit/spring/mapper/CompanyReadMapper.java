package com.abit.spring.mapper;

import com.abit.spring.dto.CompanyDto;
import com.abit.spring.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyDto> {
    @Override
    public CompanyDto map(Company obj) {
        return new CompanyDto(
                obj.getId(),
                obj.getName());
    }
}