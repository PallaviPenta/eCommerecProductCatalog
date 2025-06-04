package com.example.product.controller;
import com.example.product.entity.ProductItem;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/products")
public class ProductController {
    @Autowired private ProductService productService;
    @PostMapping
    public ResponseEntity<ProductItem> addProduct(@RequestBody ProductItem product) { return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED); }
    @PutMapping("/{id}")
    public ResponseEntity<ProductItem> updateProduct(@PathVariable Long id, @RequestBody ProductItem product) { return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) { productService.deleteProduct(id); return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
    @GetMapping
    public ResponseEntity<List<ProductItem>> getAllProducts() { return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK); }
    @GetMapping("/search")
    public ResponseEntity<List<ProductItem>> searchByName(@RequestParam String name) { return new ResponseEntity<>(productService.searchByName(name), HttpStatus.OK); }
    @GetMapping("/filter/category")
    public ResponseEntity<List<ProductItem>> filterByCategory(@RequestParam String category) { return new ResponseEntity<>(productService.filterByCategory(category), HttpStatus.OK); }
    @GetMapping("/filter/price")
    public ResponseEntity<List<ProductItem>> filterByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice) { return new ResponseEntity<>(productService.filterByPriceRange(minPrice, maxPrice), HttpStatus.OK); }
    @GetMapping("/{id}")
    public ResponseEntity<ProductItem> getProductById(@PathVariable Long id) { return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK); }
}

