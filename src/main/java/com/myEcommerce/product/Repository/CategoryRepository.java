package com.myEcommerce.product.Repository;
import com.myEcommerce.product.models.Category;
import com.myEcommerce.product.models.Products;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Override
    Optional<Category> findById (UUID uuid);
    @Override
    List<Category> findAll();

    @Override
    Category save(Category category);

}
