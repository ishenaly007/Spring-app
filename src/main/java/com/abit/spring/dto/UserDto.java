package com.abit.spring.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class UserDto {
    private int id;
    private String username;
}