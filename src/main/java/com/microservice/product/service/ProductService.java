package com.microservice.product.service;

import com.microservice.product.model.Product;
import com.microservice.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public void createProduct(Product product) {
        productRepository.save(product);
        logger.info("Product saved in database !!");
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public boolean deleteProduct(String id) {
        productRepository.deleteById(id);
        return true;
    }
}
