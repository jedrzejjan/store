package com.example.store.controller;

import com.example.store.RecordNotFoundException;
import com.example.store.model.Product;
import com.example.store.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ProductController {
    private ProductRepository repository;

    public ProductController(ProductRepository repository){
        this.repository = repository;
    }


    @GetMapping("/products")
    List<Product> all(){
        return repository.findAll();
    }

    @RequestMapping("/products")
    @ResponseBody
    Product newProduct(Product newProduct){
        return repository.save(newProduct);
    }

//    one item

    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @PutMapping("/products/{id}")
    Product changeProduct(Product newProduct, @PathVariable Long id){
        return repository.findById(id).map(product -> {
            product.setName(newProduct.getName());
            product.setCategory(newProduct.getCategory());
            product.setSeller(newProduct.getSeller());
            return repository.save(product);
        }).orElseGet(() -> {
            newProduct.setId(id);
            return repository.save(newProduct);
        });
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
    }
}
