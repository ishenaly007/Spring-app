package com.abit.spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "locales")
@Data
@Builder
@Entity
public class Company implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @ElementCollection
    @Builder.Default
    @MapKeyColumn(name = "lang")
    @CollectionTable(name = "company_locales", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "description")
    private Map<String, String> locales = new HashMap<>();
}