package controller;

import entity.Product;
import service.ProductService;

import java.sql.SQLException;

public class ProductController {

    private ProductService productService;

    public ProductController() {
        this.productService = new ProductService();
    }

    public boolean addProduct(Product product) throws Exception {
        return productService.addProduct(product);
    }
}
