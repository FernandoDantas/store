package com.product.store.service;

import com.product.store.entity.Product;
import com.product.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> getAllProductsBySort(Sort sort) {
        return productRepository.findAll(sort);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }


    public List<Product> searchProducts(String name, String category){
        if (name != null && category != null) {
            return productRepository.findByNameContainingAndCategoryNameContaining(name, category);
        } else if (name != null) {
            return productRepository.findByNameContaining(name);
        } else if (category != null) {
            return productRepository.findByCategoryNameContaining(category);
        } else {
            return productRepository.findAll();
        }
    }

}
