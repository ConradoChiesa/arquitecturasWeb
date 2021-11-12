package com.grupo10.despensa.controller;

import com.grupo10.despensa.entity.Client;
import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.entity.Sale;
import com.grupo10.despensa.service.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/sales")
public class SaleController {

    @Autowired
    private SaleServiceImpl saleService;

    @PostMapping("/buyProduct")
    public Sale buyProduct(@RequestBody Client client, Product product) {
        return saleService.buyProduct(client, product);
    }

    @GetMapping("/getSales")
    public Iterable<Sale> getSales() {
        return saleService.getSales();
    }
    @GetMapping("/getSaleByIdClient")
    public Iterable<Sale> getSaleByIdClient(Client client) {
        return saleService.getSaleByIdClient(client);
    }
}
