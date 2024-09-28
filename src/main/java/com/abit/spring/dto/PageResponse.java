package com.abit.spring.dto;

import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;

@Value
public class PageResponse<T> {
    List<T> content;
    Metadata metadata;

    public static <T> PageResponse<T> of(Page<T> page) {
        var metadata = new Metadata(page.getNumber(), page.getSize(), page.getTotalPages());
        return new PageResponse<>(page.getContent(), metadata);

    }

    @Value
    public static class Metadata {
        int page;
        int size;
        int totalElements;
    }
}