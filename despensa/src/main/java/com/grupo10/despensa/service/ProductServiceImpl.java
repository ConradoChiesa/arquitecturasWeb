package com.grupo10.despensa.service;

import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.entity.Sale;
import com.grupo10.despensa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    EntityManager em;

    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void addProducts(List<Product> products) {
        productRepository.saveAll(products);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void removeProduct(Product product) {
        productRepository.delete(product);
    }

    public Product getById(Integer id) {
        Product product = new Product();
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            product = productOptional.get();
        }
        return product;
    }

//    public Product getBestSeller() throws Exception {
//        Iterable<Product> product = em.createQuery("SELECT prod from Product prod where prod.idProduct = " +
//                        "(select sale.product.idProduct from Sale sale group by sale.product.idProduct)")
//                .getResultList();
//        if (product.iterator().hasNext()) {
//            return product.iterator().next();
//        }
//        throw new Exception("No se encontro producto");
//    }

}
