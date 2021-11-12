package com.grupo10.despensa.repository;

import com.grupo10.despensa.entity.Client;
import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.entity.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale, Integer> {
}
