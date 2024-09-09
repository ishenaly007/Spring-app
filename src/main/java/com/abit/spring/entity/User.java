package com.abit.spring.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class User {
    private int id;
    private String username;
}