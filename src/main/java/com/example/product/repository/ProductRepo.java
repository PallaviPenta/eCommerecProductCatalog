package com.example.product.repository;
import com.example.product.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<ProductItem, Long> {
    List<ProductItem> findByNameContainingIgnoreCase(String name);
    List<ProductItem> findByCategoryIgnoreCase(String category);
    @Query("SELECT p FROM ProductItem p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<ProductItem> findByPriceBetween(Double minPrice, Double maxPrice);
}
