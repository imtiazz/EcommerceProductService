package com.myEcommerce.product.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Setter
@Getter

public class CategoryDTO {
    //private UUID uuid;
    private String name;
    private List<ProductDTO> products=new ArrayList<>();

}
