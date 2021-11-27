package com.grupo10.despensa.repository;

import com.grupo10.despensa.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("SELECT p FROM Product AS p WHERE p.name = :name")
    Product findByName(@Param("name") String name);

    //@Query("SELECT MAX(p.quantity) FROM Product AS p JOIN Sale AS s " +
    //        "ON p.idProduct = s.products.WHERE p.name = :name")
    //Product findBestSeller();
}
