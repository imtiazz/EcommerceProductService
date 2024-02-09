package com.myEcommerce.product.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity



public class Category extends BaseModel{
    @Column(unique = true,nullable = false)
    private String name;
    @OneToMany(mappedBy = "category" ,fetch = FetchType.LAZY)
    private List<Products> productsList;
}
