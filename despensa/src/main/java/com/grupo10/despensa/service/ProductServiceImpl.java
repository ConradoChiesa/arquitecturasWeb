package com.grupo10.despensa.service;

import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts() {
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

    public Product getById(Integer id) {
        Product product = new Product();
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            product = productOptional.get();
        }
        return product;
    }
}
