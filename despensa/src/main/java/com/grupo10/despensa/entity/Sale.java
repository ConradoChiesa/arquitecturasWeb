package com.grupo10.despensa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSale;

    @OneToMany
    private List<Product> products;

    @OneToOne
    private Client client;

    private Date date;

}
