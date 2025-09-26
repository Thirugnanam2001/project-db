package com.example.demo_spring.product_db.service;

import com.example.demo_spring.product_db.entity.Product;
import com.example.demo_spring.product_db.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return  productRepository.findByCategory(category);
    }
}
