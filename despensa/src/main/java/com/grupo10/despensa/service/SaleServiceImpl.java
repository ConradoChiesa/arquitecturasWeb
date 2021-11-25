package com.grupo10.despensa.service;

import com.grupo10.despensa.entity.Client;
import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.entity.Sale;
import com.grupo10.despensa.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service
public class SaleServiceImpl {

    @Autowired
    private SaleRepository saleRepository;

    @PersistenceContext
    EntityManager em;

    public Sale sell(Sale sale) {

        sale.setDate(new Date());
        return saleRepository.save(sale);
    }

    public Iterable<Sale> getSales() {
        return saleRepository.findAll();
    }



    public Iterable<Sale> getSaleByIdClient(Client client) {
        List<Sale> sales = em.createQuery("SELECT sale from Sale sale where sale.client = ?1")
                .setParameter(1, client)
                .getResultList();
        return sales;
    }
}
