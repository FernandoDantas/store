package com.product.store.repository;


import com.product.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContaining(String name);

    List<Product> findByCategoryNameContaining(String category);

    List<Product> findByNameContainingAndCategoryNameContaining(String name, String category);

}
