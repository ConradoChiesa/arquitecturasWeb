package com.grupo10.despensa.controller;

import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.service.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path="/getProducts")
    public @ResponseBody
    Iterable<Product> getProducts() {
       LOGGER.info("Loading products... ");
    return productService.getProducts(); }

    @GetMapping("/getById")
    public Product getProductById(@RequestParam Integer id){
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

}