package com.myEcommerce.product.services;

import com.myEcommerce.product.Repository.CategoryRepository;
import com.myEcommerce.product.dtos.CategoryDTO;
import com.myEcommerce.product.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class SelfCategoryService implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

//    //public SelfCategoryService(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }

    @Override
    public Category getCategory(String id) {
        Optional<Category> category = categoryRepository.findById(UUID.fromString(id));
        if(category.isPresent()){
            return category.get();
        }
        return null;

    }

    @Override
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }
    @Override
    public Category addCategory(CategoryDTO categoryDTO) {
        Category category=new Category();
        System.out.println(category.getUuid());
        category.setName(categoryDTO.getName());
        return categoryRepository.save(category);
    }
}
