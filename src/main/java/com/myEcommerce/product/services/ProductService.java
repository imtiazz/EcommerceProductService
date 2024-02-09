package com.myEcommerce.product.services;

import com.myEcommerce.product.CustomException.NoSuchElementFoundException;
import com.myEcommerce.product.dtos.GenericproductDTOs;
import com.myEcommerce.product.dtos.ProductDTO;
import com.myEcommerce.product.models.Products;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

public interface ProductService {

Products createProduct(ProductDTO product) throws NoSuchElementFoundException;
Products getProductById(UUID id) throws NoSuchElementFoundException;
Products updateProduct(String id,ProductDTO productDTO) throws NoSuchElementFoundException;
void deleteProduct(String id) throws NoSuchElementFoundException;

List<Products> getAllProduct();
    
}
