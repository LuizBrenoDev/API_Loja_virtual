package com.luizdev.mypost.domain.DTO;

import java.io.Serializable;
import java.util.List;

import com.luizdev.mypost.domain.entities.Product;
import com.luizdev.mypost.domain.entities.Seller;

public class SellerDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;
    private String email;
    private String contactPhone;
    private List<Product> products;

    public SellerDTO() {

    }

    public SellerDTO(Seller seller){
        this.id = seller.getId();
        this.name =  seller.getName();
        this.email = seller.getEmail();
        this.contactPhone = seller.getContactPhone();
        this.products = seller.getProducts();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    
}
