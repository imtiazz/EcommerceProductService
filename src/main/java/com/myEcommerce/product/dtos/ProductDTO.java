package com.myEcommerce.product.dtos;

import com.myEcommerce.product.models.Category;
import com.myEcommerce.product.models.Price;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private String name;
    private String description;
    private PriceDTO price;
    private String categoryId;

}
