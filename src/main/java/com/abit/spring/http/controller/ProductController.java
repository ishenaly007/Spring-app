package com.abit.spring.http.controller;

import com.abit.spring.dto.ProductReadDto;
import com.abit.spring.entity.ProductType;
import com.abit.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String findAllProducts(Model model) {
        List<ProductReadDto> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "product/products";
    }

    @GetMapping("/{id}")
    public String findProductById(@PathVariable("id") Integer id, Model model) {
        return productService.findProductById(id).map(product -> {
            model.addAttribute("product", product);
            model.addAttribute("types", ProductType.values());
            return "product/product";
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}