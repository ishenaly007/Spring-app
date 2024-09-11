package com.abit.spring.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class Company {
    private Integer id;
    private String name;
}