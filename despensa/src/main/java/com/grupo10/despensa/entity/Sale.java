package com.grupo10.despensa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "sale")
public class Sale {

    @Id
    private Integer idSale;

    @OneToOne
    private Product product;

    @OneToOne
    private Client client;

    private Date date;

    //Como funciona esto en realidad que fecha es la que carga? la persiste mejor lo dejo hecho en el servicio
    /*
    @PrePersist
    protected void onCreate() {
        date = new Date();
    }
    */
}
