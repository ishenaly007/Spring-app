package com.abit.spring.dto;

import com.abit.spring.entity.ProductType;
import lombok.ToString;
import lombok.Value;

@Value
public class ProductReadDto {
    int id;
    String name;
    String description;
    Integer price;
    String image;
    ProductType type;
    String color;
}