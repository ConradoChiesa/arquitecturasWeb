package com.grupo10.despensa.controller;

import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.service.ProductServiceImpl;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/product")
@CrossOrigin(origins = {"http://localhost:4200", "https://despensafrontend-team10.herokuapp.com"})
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Operation"),
            @ApiResponse(code = 403, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Resurce Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })

    @PostMapping(path = "/add")
    public void addProduct(@RequestBody Product product) throws Exception {
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
    @GetMapping("/getByName")
    public Product getById(@RequestBody Product product){
        LOGGER.info("Getting product by id... ");
        return productService.getByName(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) throws Exception {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/remove")
    public void remove(@RequestBody Product product){
        productService.removeProduct(product);
    }

    @GetMapping("/bestSeller")
    public Product getBestSeller() throws Exception {
        LOGGER.info("Getting Best Seller... ");
        return productService.getBestSeller();
    }
}