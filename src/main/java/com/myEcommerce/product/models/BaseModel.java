package com.myEcommerce.product.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator = "imtiaz")
    @GenericGenerator(name = "imtiaz", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID uuid;
}
