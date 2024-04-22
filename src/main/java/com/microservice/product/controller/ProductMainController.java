package com.microservice.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductMainController {

    @GetMapping(path = "/status")
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<>("application up & running!", HttpStatus.OK);
    }
}
