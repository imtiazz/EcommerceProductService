package com.myEcommerce.product.controllers;

import com.myEcommerce.product.CustomException.NoSuchElementFoundException;
import com.myEcommerce.product.dtos.GenericproductDTOs;
import com.myEcommerce.product.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/products")

public class productController {
    private ProductService productService;

    public productController(@Qualifier("FakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<GenericproductDTOs> getAllproducts(){

       return productService.getAllProduct();
    }
    @GetMapping("{id}")
    public GenericproductDTOs getProductById(@PathVariable("id") Long id) throws NoSuchElementFoundException {

            return productService.getProductById(id);

    }

    @PostMapping
    public GenericproductDTOs addProduct(@RequestBody GenericproductDTOs product){
        return productService.createProduct(product);

    }

    @PutMapping("{id}")
    public  GenericproductDTOs updateProduct(@PathVariable("id") Long id,@RequestBody GenericproductDTOs product){
        return productService.updateProduct(id,product);


    }


    @DeleteMapping("{id}")
    public GenericproductDTOs deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);

    }




}
