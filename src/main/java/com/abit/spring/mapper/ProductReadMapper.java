package com.abit.spring.mapper;

import com.abit.spring.dto.ProductReadDto;
import com.abit.spring.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductReadMapper implements Mapper<Product, ProductReadDto> {
    @Override
    public ProductReadDto map(Product obj) {
        return new ProductReadDto(
                obj.getId(),
                obj.getName(),
                obj.getDescription(),
                obj.getPrice(),
                obj.getImage(),
                obj.getType(),
                obj.getColor()
        );
    }
}