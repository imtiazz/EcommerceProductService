package com.myEcommerce.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myEcommerce.product.CustomException.NoSuchElementFoundException;
import com.myEcommerce.product.controllers.productController;
import com.myEcommerce.product.dtos.ProductDTO;
import com.myEcommerce.product.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(productController.class)

public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private productController productController;

    @Test
    void getAllProductsReturnEmptyListWhenNoProductAvailable() throws Exception {
        ArrayList<ProductDTO> productDTO=new ArrayList<>();
        when(productController.getAllproducts()).thenReturn(productDTO);
        mockMvc.perform(get("/products")).andExpect(status().is(200)).andExpect(content().string("[]"));
    }
    @Test
    void getProductbyIdSuccessFully() throws Exception {
        String id="1";
        ProductDTO productDTO=new ProductDTO();
        productDTO.setName("TestProduct");
        productDTO.setDescription("test");
        String response=new ObjectMapper().writeValueAsString(productDTO);
        when(productController.getProductById(id)).thenReturn(productDTO);
        mockMvc.perform(get("/products/1")).andExpect(status().is(200)).andExpect(content().string(response));

    }
    @Test
    void productNotFoundExceptionTest(){
       // when(productController.getProductById("1")).thenThrow());



    }

}
