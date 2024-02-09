package com.myEcommerce.product.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
@Setter
@Getter
public class BaseModel {
    @Id
    @GeneratedValue(generator = "imtiaz")
    @GenericGenerator(name = "imtiaz", strategy = "uuid2")
    @Column(name = "id",columnDefinition = "binary(16)", nullable = false, updatable = false)
    private UUID uuid;
}
