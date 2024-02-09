package com.myEcommerce.product.controllers;

import com.myEcommerce.product.CustomException.NoSuchElementFoundException;
import com.myEcommerce.product.dtos.CategoryDTO;
import com.myEcommerce.product.dtos.GenericproductDTOs;
import com.myEcommerce.product.dtos.PriceDTO;
import com.myEcommerce.product.dtos.ProductDTO;
import com.myEcommerce.product.models.Products;
import com.myEcommerce.product.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/products")

public class productController {
    private ProductService productService;

    public productController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }

    ProductDTO convertToProductDTOs(Products product){
        ProductDTO productDTO=new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategoryId(product.getCategory().getUuid().toString());
        PriceDTO priceDTO=new PriceDTO();
        priceDTO.setPrice(product.getPrice().getPrice());
        priceDTO.setCurrency(product.getPrice().getCurrency());
        productDTO.setPrice(priceDTO);
        return productDTO;
    }

    @GetMapping()
    public List<ProductDTO> getAllproducts(){
        ArrayList<ProductDTO> productDTOS=new ArrayList<>();
        List<Products> products=productService.getAllProduct();
        for (Products product:products) {
           productDTOS.add(convertToProductDTOs(product));
           System.out.println(product.getUuid());
        }
       return productDTOS;

    }
    @GetMapping("{id}")
    public ProductDTO getProductById(@PathVariable("id") String id) throws NoSuchElementFoundException {

        Products product=productService.getProductById(UUID.fromString(id));
        return convertToProductDTOs(product);


    }

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) throws NoSuchElementFoundException {
        return convertToProductDTOs(productService.createProduct(productDTO));

    }

    @PutMapping("{id}")
    public  ProductDTO updateProduct(@PathVariable("id") String id,@RequestBody ProductDTO productDTO) throws NoSuchElementFoundException {
        return convertToProductDTOs(productService.updateProduct(id,productDTO));


    }


    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") String id) throws NoSuchElementFoundException {
         productService.deleteProduct(id);

    }
}
