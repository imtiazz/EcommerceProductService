package com.myEcommerce.product;

import com.myEcommerce.product.Repository.CategoryRepository;
import com.myEcommerce.product.Repository.Productrepository;
import com.myEcommerce.product.models.Category;
import com.myEcommerce.product.models.Price;
import com.myEcommerce.product.models.Products;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.PrivateKey;

@SpringBootApplication
public class ProductApplication  {
//	private CategoryRepository categoryRepository;
//	private Productrepository productrepository;
//	public ProductApplication(Productrepository productrepository,CategoryRepository categoryRepository) {
//		this.productrepository=productrepository;
//		this.categoryRepository=categoryRepository;
//
//}

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
//	@Override
//	public void run(String... args) throws Exception {
////		System.out.println("Hello World");
////		Category category=new Category();
////		category.setName("Electronics");
////		category.setDescription("Electronics by Imtiaz");
////		categoryRepository.save(category);
//
////		Price price=new Price();
////		price.setPrice(1000);
////		price.setCurrency("RS");
////
////
////		Products products=new Products();
////		products.setName("Mobile");
////		products.setDescription("Mobile by Imtiaz");
////		products.setPrice(price);
////		products.setCategory(category);
////		productrepository.save(products);
//
//	}
}
