package com.abit.spring.service;

//import com.abit.spring.database.repository.ProductRepository;
import com.abit.spring.database.repository.ProductRepository;
import com.abit.spring.dto.ProductReadDto;
import com.abit.spring.mapper.ProductReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductReadMapper productReadMapper;

    public List<ProductReadDto> findAll() {
        return productRepository.findAll().stream().map(productReadMapper::map).toList();
    }

    public Optional<ProductReadDto> findById(Integer id) {
        return productRepository.findById(id).map(productReadMapper::map);
    }
}