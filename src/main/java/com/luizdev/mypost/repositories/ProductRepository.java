package com.luizdev.mypost.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luizdev.mypost.domain.entities.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
    
}
