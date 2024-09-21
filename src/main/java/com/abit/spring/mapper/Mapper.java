package com.abit.spring.mapper;

public interface Mapper<F, T> {
    T map(F obj);

    default T map(F obj, T to) {
        return to;
    }
}