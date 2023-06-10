package com.luizdev.mypost.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizdev.mypost.domain.entities.Product;
import com.luizdev.mypost.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> allProducts(){
        return repository.findAll();
    }
}
