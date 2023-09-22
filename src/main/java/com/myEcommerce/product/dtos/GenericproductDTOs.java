package com.myEcommerce.product.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericproductDTOs {

    private  Long id;
    private String title;
    private  int price;
    private  String description;
    private String image;
    private  String category;

}
