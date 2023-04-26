package com.luizdev.mypost.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizdev.mypost.domain.DTO.SellerDTO;
import com.luizdev.mypost.domain.entities.Product;
import com.luizdev.mypost.domain.entities.Seller;
import com.luizdev.mypost.services.SellerService;

@RestController
@RequestMapping(value="/sellers")
public class SellerResource {

    @Autowired
    private SellerService service;

    @GetMapping
    public ResponseEntity<List<SellerDTO>> allSellers(){
        List<Seller> sellers = service.allSellers();
        List<SellerDTO> dtos = sellers.stream()
                            .map(s -> new SellerDTO(s))
                            .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<SellerDTO> findSellerById(@PathVariable String id){
        Seller seller = service.findSellerById(id);
        return ResponseEntity.ok().body(new SellerDTO(seller));

    }

    @GetMapping(value="{id}/products")
    public ResponseEntity<List<Product>> allProducts(@PathVariable String id){
        Seller seller = service.findSellerById(id);
        return ResponseEntity.ok().body(seller.getProducts());
    }

    
}
