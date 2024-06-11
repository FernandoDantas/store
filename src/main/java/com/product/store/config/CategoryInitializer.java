package com.product.store.config;

import com.product.store.entity.Category;
import com.product.store.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryInitializer {

    @Bean
    public CommandLineRunner loadDataCategory(CategoryRepository categoryRepository) {

        return args -> {
            categoryRepository.save(new Category("Electronics"));
            categoryRepository.save(new Category("Books"));
            categoryRepository.save(new Category("Clothing"));
            categoryRepository.save(new Category("Home & Kitchen"));
            categoryRepository.save(new Category("Sports & Outdoors"));
        };
    }
}
