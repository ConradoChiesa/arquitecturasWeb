package com.grupo10.despensa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Product {

    @Id
    private Integer idProduct;

    private String name;
    private String description;
    private Integer quantity;
}
