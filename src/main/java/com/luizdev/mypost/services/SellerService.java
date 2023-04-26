package com.luizdev.mypost.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizdev.mypost.domain.entities.Seller;
import com.luizdev.mypost.exceptions.UserNotFoundException;
import com.luizdev.mypost.repositories.SellerRepository;

@Service
public class SellerService {
    
    @Autowired
    private SellerRepository repository;

    public List<Seller> allSellers(){
        return repository.findAll();
    }

    public Seller findSellerById(String id){
        Optional<Seller> seller = repository.findById(id);
        return seller.orElseThrow(() -> new UserNotFoundException("Vendedor não encontrado"));
    }

    public Seller insert(Seller seller){
        return repository.insert(seller);
    }

    
}
