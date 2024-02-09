package com.myEcommerce.product.Repository;

import com.myEcommerce.product.models.Products;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Productrepository extends JpaRepository<Products, UUID> {
    @Override
    List<Products> findAll();

    @Override
    Optional<Products> findById(UUID uuid);


    Optional<Products> findByName(String name);

    @Override
    Products save(Products products);

    @Override
    void delete(Products products);

    @Override
    void deleteById(UUID uuid);

    @Override
    //update products
    <S extends Products> S saveAndFlush(S s);

}

