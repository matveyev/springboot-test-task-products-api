package com.example.testtask.controller;

import java.util.List;
import com.example.testtask.entity.Product;
import com.example.testtask.exception.ProductNotFoundException;
import com.example.testtask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
public class ProductsController {
    @Autowired
    private final ProductRepository productRepository;

    ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    Product getById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @DeleteMapping("/products/{id}")
    void deleteById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @PostMapping("/products")
    Product createProduct(@RequestBody Product newProduct) {
        // TODO: validation
        return productRepository.save(newProduct);
    }

    @PutMapping("/products/{id}")
    Product updateProduct(@RequestBody Product updatedProduct, @PathVariable Long id) {
        // TODO: validation
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setAmount(updatedProduct.getAmount());

                    productRepository.save(product);
                    return product;
                })
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @GetMapping("/products/amount_sum/{name}")
    Long getSumByName(@PathVariable String name) {
        return productRepository.getAmountSumByName(name);
    }
}
