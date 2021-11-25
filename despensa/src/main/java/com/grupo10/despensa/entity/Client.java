package com.grupo10.despensa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue
    private Integer idClient;
    private String name;

}
