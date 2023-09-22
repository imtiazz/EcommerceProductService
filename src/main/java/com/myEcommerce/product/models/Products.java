package com.myEcommerce.product.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Products extends BaseModel{
    private String name;
    private String description;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Price price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

}
