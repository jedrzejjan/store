package com.example.store;

import com.example.store.model.Product;
import com.example.store.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.store.model.Seller;
import com.example.store.repository.SellerRepository;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(SellerRepository sellerRepository, ProductRepository productRepository) {
        return args -> {
            log.info("Preloading " + sellerRepository.save(new Seller("Bilbo Baggins")));
            log.info("Preloading " + sellerRepository.save(new Seller("Frodo Baggins")));
            log.info("Preloading " + productRepository.save(new Product("tv", "rtvagd", sellerRepository.findById(1L).orElse(new Seller()))));
            log.info("Preloading " + productRepository.save(new Product("dryer", "rtvagd", sellerRepository.findById(2L).orElse(new Seller()))));
            log.info("Preloading " + productRepository.save(new Product("pc", "rtvagd", sellerRepository.findById(1L).orElse(new Seller()))));
            log.info("Preloading " + productRepository.save(new Product("lamp", "furniture", sellerRepository.findById(2L).orElse(new Seller()))));
            log.info("Preloading " + productRepository.save(new Product("desk", "furniture", sellerRepository.findById(1L).orElse(new Seller()))));
        };
    }
}
