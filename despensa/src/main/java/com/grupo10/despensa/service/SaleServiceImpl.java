package com.grupo10.despensa.service;

import com.grupo10.despensa.entity.Client;
import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.entity.Sale;
import com.grupo10.despensa.repository.SaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;

@Service
public class SaleServiceImpl {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductServiceImpl productService;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public Sale sell(Sale sale) throws Exception {
        //Le seteo la fecha a la venta
        //resta los productos del stock
        LOGGER.info("Recived Product: "+sale.getIdProduct());
        sale.setDate(new Date());

        return removeSelledProduct(sale);
    }

    private Sale removeSelledProduct(Sale sale) throws Exception {
        //Si los prod alcanzan
        Product persistedProduct = productService.getById(sale.getIdProduct());
        if (persistedProduct.getQuantity() > 0) {
            LOGGER.info("removeSeller " + sale.toString());
            persistedProduct.setQuantity(persistedProduct.getQuantity() - 1);
            productService.selledProduct(persistedProduct);
        } else {
            throw new Exception("No hay tantos productos, la venta no puede concretarse");
        }
        return sale;
    }

    public Iterable<Sale> getSales() {
        return saleRepository.findAll();
    }



    public Iterable<Sale> getSalesByIdClient(Client client) {
        return saleRepository.getSalesByIdClient(client.getIdClient());
    }
}
