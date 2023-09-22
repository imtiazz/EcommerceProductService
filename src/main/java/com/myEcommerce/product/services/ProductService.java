package com.myEcommerce.product.services;

import com.myEcommerce.product.CustomException.NoSuchElementFoundException;
import com.myEcommerce.product.dtos.GenericproductDTOs;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface ProductService {

GenericproductDTOs createProduct(GenericproductDTOs product);
GenericproductDTOs getProductById(Long id) throws NoSuchElementFoundException;
GenericproductDTOs updateProduct(Long id,GenericproductDTOs product);
GenericproductDTOs deleteProduct(Long id);

List<GenericproductDTOs> getAllProduct();
    
}
