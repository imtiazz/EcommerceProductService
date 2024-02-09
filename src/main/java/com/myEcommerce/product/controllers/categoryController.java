package com.myEcommerce.product.controllers;

import com.myEcommerce.product.CustomException.NoSuchElementFoundException;
import com.myEcommerce.product.dtos.CategoryDTO;
import com.myEcommerce.product.models.Category;
import com.myEcommerce.product.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")

public class categoryController {

    @Autowired

    CategoryService categoryService;

//    public categoryController(@Qualifier("SelfCategoryService") CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

    private CategoryDTO convertToCategoryDTOs(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable("id") String id) throws NoSuchElementFoundException {
        Category category = categoryService.getCategory(id);
        if (category == null) {
            throw new NoSuchElementFoundException("No such category found");
        }
        return convertToCategoryDTOs(category);
    }

    @PostMapping()
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return convertToCategoryDTOs(categoryService.addCategory(categoryDTO));
    }

    @GetMapping()
    public ArrayList<CategoryDTO> getAllCategories() {
        ArrayList<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<Category> categories = categoryService.getAllCategories();
        for (Category category : categories) {
            categoryDTOS.add(convertToCategoryDTOs(category));
            System.out.println(category.getUuid());
        }
        return categoryDTOS;

    }
}
