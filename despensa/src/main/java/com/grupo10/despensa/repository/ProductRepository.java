package com.grupo10.despensa.repository;

import com.grupo10.despensa.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {


    Product findByName(String name);
}
