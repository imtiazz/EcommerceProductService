package com.myEcommerce.product.services;

import com.myEcommerce.product.dtos.CategoryDTO;
import com.myEcommerce.product.models.Category;
import com.myEcommerce.product.models.Products;

import java.util.List;

public interface CategoryService {

    Category getCategory(String uuid);
    public List<Category> getAllCategories();

    public Category addCategory(CategoryDTO categoryDTO);
}
