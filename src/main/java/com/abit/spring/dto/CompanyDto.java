package com.abit.spring.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class CompanyDto {
    private Integer id;
    private String name;
}