package com.myEcommerce.product.services;

import com.myEcommerce.product.CustomException.NoSuchElementFoundException;
import com.myEcommerce.product.Repository.CategoryRepository;
import com.myEcommerce.product.Repository.Productrepository;
import com.myEcommerce.product.ThirdPartyAPIs.FakeStorePostDTOs;
import com.myEcommerce.product.dtos.GenericproductDTOs;
import com.myEcommerce.product.dtos.ProductDTO;
import com.myEcommerce.product.models.Category;
import com.myEcommerce.product.models.Price;
import com.myEcommerce.product.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary

@Service("SelfProductService")

public class SelfProductService implements ProductService{

    @Autowired
    private Productrepository productrepository;

    @Autowired
    private CategoryRepository categoryRepository;

//    public SelfProductService(Productrepository productrepository,CategoryRepository categoryRepository) {
//        this.productrepository = productrepository;
//        this.categoryRepository=categoryRepository;
//    }

        @Override
        public Products createProduct(ProductDTO productDTO) throws NoSuchElementFoundException {
        Products products=new Products();
        //System.out.println(products.getUuid());
        products.setName(productDTO.getName());
        products.setDescription(productDTO.getDescription());
        Price price=new Price();
        price.setPrice(productDTO.getPrice().getPrice());
        price.setCurrency(productDTO.getPrice().getCurrency());
        products.setPrice(price);
        Category category=categoryRepository.findById(UUID.fromString(productDTO.getCategoryId())).get();
       if (category!=null) {
            products.setCategory(category);
            products.getCategory().getProductsList().add(products);
            categoryRepository.save(category);
        }

        return productrepository.save(products);

        }

        @Override
        public Products getProductById(UUID id) throws NoSuchElementFoundException {

        Optional<Products> products=productrepository.findById(id);
        if (products.isEmpty()) {
            throw new NoSuchElementFoundException("No such product found");
        }
        return products.get();

        }
        @Override
        public Products updateProduct(String id,ProductDTO productDTO) throws NoSuchElementFoundException {
            Optional<Products> products=productrepository.findById(UUID.fromString(id));
            if (products.isEmpty()) {
                throw new NoSuchElementFoundException("No such product found");
            }
            if (productDTO.getName()!=null) {
                products.get().setName(productDTO.getName());
            }
            if (productDTO.getDescription()!=null) {
                products.get().setDescription(productDTO.getDescription());
            }
            if (productDTO.getPrice()!=null) {
                products.get().getPrice().setPrice(productDTO.getPrice().getPrice());
                products.get().getPrice().setCurrency(productDTO.getPrice().getCurrency());
            }
            if (productDTO.getCategoryId()!=null) {
                Category category=categoryRepository.findById(UUID.fromString(productDTO.getCategoryId())).get();
                if (category!=null) {
                    products.get().setCategory(category);
                    products.get().getCategory().getProductsList().add(products.get());
                    categoryRepository.save(category);
                }
            }
            return productrepository.save(products.get());

        }


        @Override
        public void deleteProduct(String id) throws NoSuchElementFoundException {
           Optional<Products> products= productrepository.findById(UUID.fromString(id));
           if (products.isEmpty()) {
               throw new NoSuchElementFoundException("No such product found");
              }
            productrepository.deleteById(UUID.fromString(id));
        }



        @Override
        public List<Products> getAllProduct() {

            return productrepository.findAll();
        }

}
