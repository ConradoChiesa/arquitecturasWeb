package com.grupo10.despensa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Client {

    @Id
    private Integer idClient;
}
