package service;

import daoImpl.ProductDAOImpl;
import entity.Product;

import java.sql.SQLException;

public class ProductService {

    private ProductDAOImpl productDAOImpl;

    public ProductService() {
        this.productDAOImpl = new ProductDAOImpl();
    }

    public boolean addProduct(Product product) throws Exception {
        int idProduct = product.getIdProduct();
        String name = product.getName();
        float amount = product.getAmount();
        return productDAOImpl.addProduct(idProduct, name, amount);
    }
}
