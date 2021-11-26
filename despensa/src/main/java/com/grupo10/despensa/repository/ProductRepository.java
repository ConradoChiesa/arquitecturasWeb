package com.grupo10.despensa.repository;

import com.grupo10.despensa.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = "SELECT p FROM Product AS p WHERE p.name = :name")
    Product findByName(@Param("name") String name);
}
