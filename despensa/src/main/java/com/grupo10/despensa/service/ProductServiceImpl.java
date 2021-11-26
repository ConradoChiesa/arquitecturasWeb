package com.grupo10.despensa.service;

import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) throws Exception {
        Product p = productRepository.findByName(product.getName());
        if (p != null) {
            throw new Exception("Ya existe un producto con ese nombre");
        }
        return productRepository.save(product);
    }

    public void addProducts(List<Product> products) {
        productRepository.saveAll(products);
    }

    //Este servicio trae la cantidad que hay en la bbdd y los actualiza
    public Product updateProduct(Product product) throws Exception {
        Product prodPersisted = productRepository.findByName(product.getName());
        product.setQuantity(product.getQuantity() + prodPersisted.getQuantity());
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

    public Product getBestSeller() throws Exception {
        /*Iterable<Product> product = em.createQuery("SELECT prod from Product prod where prod.idProduct = " +
                        "(select sale.product.idProduct from Sale sale group by sale.product.idProduct)")
                .getResultList();
        if (product.iterator().hasNext()) {
            return product.iterator().next();
        }*/
        throw new Exception("No se encontro producto");
    }

    public Product getByName(Product product) {
        return productRepository.findByName(product.getName());
    }

}
