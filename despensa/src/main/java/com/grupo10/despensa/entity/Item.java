package com.grupo10.despensa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    private Integer idItem;
    @OneToOne
    @JoinColumn(name = "idProduct")
    private Product product;
    private Integer quantity;
}
