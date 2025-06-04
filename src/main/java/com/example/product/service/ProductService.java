package com.example.product.service;
import com.example.product.entity.ProductItem;
import com.example.product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    @Autowired private ProductRepo productRepo;
    public ProductItem addProduct(ProductItem product) { return productRepo.save(product); }
    public ProductItem updateProduct(Long id, ProductItem product) { product.setId(id); return productRepo.save(product); }
    public void deleteProduct(Long id) { productRepo.deleteById(id); }
    public List<ProductItem> getAllProducts() { return productRepo.findAll(); }
    public List<ProductItem> searchByName(String name) { return productRepo.findByNameContainingIgnoreCase(name); }
    public List<ProductItem> filterByCategory(String category) { return productRepo.findByCategoryIgnoreCase(category); }
    public List<ProductItem> filterByPriceRange(Double minPrice, Double maxPrice) { return productRepo.findByPriceBetween(minPrice, maxPrice); }
    public ProductItem getProductById(Long id) { return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found")); }
}
