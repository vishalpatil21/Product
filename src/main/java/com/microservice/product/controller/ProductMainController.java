package com.microservice.product.controller;

import com.microservice.product.model.Product;
import com.microservice.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductMainController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/status")
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<>("application up & running!", HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product prod) {
        productService.createProduct(prod);
    }

    @GetMapping("/get/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct() {
        productService.getAllProduct();
        return productService.getAllProduct();

    }

    @DeleteMapping(value = {"/delete/{id}"})
    public boolean deleteProduct(@PathVariable  String id){
        return productService.deleteProduct(id);
    }
}
