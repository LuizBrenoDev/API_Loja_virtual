package com.luizdev.mypost.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizdev.mypost.domain.entities.Product;
import com.luizdev.mypost.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> allProducts(){
        List<Product> products = service.allProducts();
        return ResponseEntity.ok().body(products);
    }
}
