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
    @Column(nullable = false,unique = true)
    private String name;
    private String description;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Price price;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category;
    //private int quantity;

}
