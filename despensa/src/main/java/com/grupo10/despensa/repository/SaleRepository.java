package com.grupo10.despensa.repository;

import com.grupo10.despensa.entity.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SaleRepository extends CrudRepository<Sale, Integer> {

    @Query("SELECT s FROM Sale s WHERE s.idClient = :idClient")
    Iterable<Sale> getSalesByIdClient(@Param("idClient")Integer idClient);

}
