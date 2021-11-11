package com.grupo10.despensa.controller;

import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping(path = "/add")
    public void addNewUser(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping(path="/getAll")
    public @ResponseBody
    Iterable<Product> getAllUsers() { return productService.getAllProducts(); }

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