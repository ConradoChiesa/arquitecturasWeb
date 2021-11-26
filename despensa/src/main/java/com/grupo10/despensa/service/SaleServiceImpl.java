package com.grupo10.despensa.service;

import com.grupo10.despensa.entity.Client;
import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.entity.Sale;
import com.grupo10.despensa.repository.SaleRepository;
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

    public Sale sell(Sale sale) throws Exception {
        //Le seteo la fecha a la venta
        //resta los productos del stock
        Iterator<Product> itProds = sale.getProducts().iterator();
        while (itProds.hasNext()) {
            removeSelledProduct(itProds.next());

        }
        sale.setDate(new Date());
        return saleRepository.save(sale);
    }

    private void removeSelledProduct(Product product) throws Exception {
        //Si los prod alcanzan
        Product persistedProduct = productService.getById(product.getIdProduct());
        if (persistedProduct.getQuantity() > product.getQuantity()) {
            persistedProduct.setQuantity(persistedProduct.getQuantity() - product.getQuantity());
            productService.updateProduct(persistedProduct);
        } else {
            throw new Exception("No hay tantos productos, la venta no puede concretarse");
        }
    }

    public Iterable<Sale> getSales() {
        return saleRepository.findAll();
    }



    public Iterable<Sale> getSaleByIdClient(Client client) {
        //List<Sale> sales = em.createQuery("SELECT sale from Sale sale where sale.client = ?1")
          //      .setParameter(1, client)
            //    .getResultList();
        return null; //sales;
    }
}
