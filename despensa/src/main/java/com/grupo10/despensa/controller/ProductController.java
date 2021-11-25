package com.grupo10.despensa.controller;

import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.service.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @PostMapping(path = "/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PostMapping("/addList")
    public void addProducts(@RequestBody List<Product> products) {
        productService.addProducts(products);
    }

    @GetMapping(path="/getAll")
    public Iterable<Product> getAll() {
       LOGGER.info("Loading products... ");
    return productService.getAll(); }

    @GetMapping("/getById")
    public Product getById(@RequestParam Integer id){
        LOGGER.info("Getting product by id... ");
        return productService.getById(id);
    }

    @PutMapping("/update")
    public Product updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/remove")
    public void remove(Product product){
        productService.removeProduct(product);
    }

//    @GetMapping("/bestSeller")
//    public Product getBestSeller() throws Exception {
//        LOGGER.info("Getting Best Seller... ");
//        return productService.getBestSeller();
//    }
}