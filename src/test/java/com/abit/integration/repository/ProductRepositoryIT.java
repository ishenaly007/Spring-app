package com.abit.integration.repository;

import com.abit.annotation.IT;
import com.abit.spring.database.repository.ProductRepository;
import com.abit.spring.dto.ProductReadDto;
import com.abit.spring.entity.Product;
import com.abit.spring.mapper.ProductReadMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IT
public class ProductRepositoryIT {
    private final ProductRepository productRepository;
    private final ProductReadMapper productReadMapper;

    public ProductRepositoryIT(@Autowired ProductRepository productRepository, @Autowired ProductReadMapper productReadMapper) {
        this.productRepository = productRepository;
        this.productReadMapper = productReadMapper;
    }

    @Test
    public void findAll() {
        List<Product> products = productRepository.findAll();
        System.out.println(products);
        assertNotNull(products);
        assertThat(products).hasSize(10);
    }

    @Test
    public void findById() {
        Optional<ProductReadDto> product = productRepository.findById(1).map(productReadMapper::map);
        System.out.println(product);
        assertNotNull(product);
        assertThat(product.get().getName()).isEqualTo("Smartphone");
    }
}