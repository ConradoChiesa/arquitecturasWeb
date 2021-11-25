package com.grupo10.despensa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Integer idProduct;
    @Column(unique = true)
    private String name;
    private String description;
    private Integer stock;
    private Integer price;

}
