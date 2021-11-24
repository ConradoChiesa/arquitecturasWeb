package com.grupo10.despensa.controller;

import com.grupo10.despensa.entity.Client;
import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.entity.Sale;
import com.grupo10.despensa.service.SaleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/sales")
@CrossOrigin(origins = "http://localhost:4200")
public class SaleController {

    @Autowired
    private SaleServiceImpl saleService;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/buyProduct")
    public Sale buyProduct(@RequestBody Client client, Product product) {
        LOGGER.info("Selling product... ");
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
