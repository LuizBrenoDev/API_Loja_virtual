package com.luizdev.mypost.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luizdev.mypost.domain.DTO.SellerDTO;
import com.luizdev.mypost.domain.entities.Product;
import com.luizdev.mypost.domain.entities.Seller;
import com.luizdev.mypost.domain.entities.User;
import com.luizdev.mypost.repositories.ProductRepository;
import com.luizdev.mypost.repositories.SellerRepository;
import com.luizdev.mypost.repositories.UserRepository;

@Configuration
public class Instantiator implements CommandLineRunner{

    @Autowired
    private UserRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        productRepository.deleteAll();
        sellerRepository.deleteAll();

        User ex1 = new User(null, "Example", "ex@gmail.com", "ex123");
        User ex2 = new User(null, "Example2", "ex2@gmail.com", "ex345");
        User ex3 = new User(null, "Example3", "ex3@gmail.com", "ex567");

        Seller seller = new Seller(null, "Seller1", "seller@gmail.com", "s123", "1234-4567", null);

        repository.saveAll(Arrays.asList(ex1,ex2,ex3));

       Product p1 = new Product(null, "TV", 2800.0, "A good TV",new SellerDTO(seller));
       Product p2 = new Product(null, "Videogame", 1100.0, "A funny Game",new SellerDTO(seller));

       productRepository.saveAll(Arrays.asList(p1,p2));

       seller.setProducts(Arrays.asList(p1,p2));

       sellerRepository.save(seller);
    }
    
}
