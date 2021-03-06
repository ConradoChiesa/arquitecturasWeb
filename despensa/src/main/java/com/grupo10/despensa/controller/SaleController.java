package com.grupo10.despensa.controller;

import com.grupo10.despensa.entity.Client;
import com.grupo10.despensa.entity.Sale;
import com.grupo10.despensa.service.SaleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/sales")
@CrossOrigin(origins = {"http://localhost:4200", "https://despensafrontend-team10.herokuapp.com"})
public class SaleController {

    @Autowired
    private SaleServiceImpl saleService;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/sell")
    public Sale buyProduct(@RequestBody Sale sale) throws Exception {
        LOGGER.info("Selling product... "+ sale.getProducts().toString());
        return saleService.sell(sale);
    }

    @GetMapping("/getSales")
    public Iterable<Sale> getSales() {
        return saleService.getSales();
    }

    @GetMapping("/getSaleByIdClient")
    public Iterable<Sale> getSaleByIdClient(@RequestBody Client client) {
        return saleService.getSaleByIdClient(client);
    }
}
