package com.grupo10.despensa.repository;

import com.grupo10.despensa.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
