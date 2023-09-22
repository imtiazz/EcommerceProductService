package com.myEcommerce.product.services;

import com.myEcommerce.product.CustomException.NoSuchElementFoundException;
import com.myEcommerce.product.dtos.GenericproductDTOs;

import java.util.List;

public class SelfProductService implements ProductService {
    @Override
    public GenericproductDTOs createProduct(GenericproductDTOs product) {
        return null;
    }

    @Override
    public GenericproductDTOs getProductById(Long id) throws NoSuchElementFoundException {
        return null;
    }

    @Override
    public GenericproductDTOs updateProduct(Long id, GenericproductDTOs product) {
        return null;
    }

    @Override
    public GenericproductDTOs deleteProduct(Long id) {
        return null;
    }

    @Override
    public List<GenericproductDTOs> getAllProduct() {
        return null;
    }
}
