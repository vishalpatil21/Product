package com.microservice.product.service;

import com.microservice.product.dto.ProductRequestDTO;
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

    public void createProduct(ProductRequestDTO prodDTO) {
        Product product = Product.builder().name(prodDTO.getName()).description(prodDTO.getDescription()).price(prodDTO.getPrice()).build();
        productRepository.save(product);
        logger.info("Product saved in database !!");
    }

    public List<Product> getAllProduct() {
       return productRepository.findAll();
    }
}
