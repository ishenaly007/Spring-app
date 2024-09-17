package com.abit.spring.entity;

import java.io.Serializable;

public interface BaseEntity<T extends Serializable> {
    void setId(T id);

    T getId();
}
