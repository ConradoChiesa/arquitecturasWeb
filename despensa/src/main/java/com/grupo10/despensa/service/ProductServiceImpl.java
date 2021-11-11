package com.grupo10.despensa.service;

import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void removeProduct(Product product) {
        productRepository.delete(product);
    }

}
