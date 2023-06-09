package com.luizdev.mypost.domain.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.luizdev.mypost.domain.DTO.SellerDTO;

@Document(collection = "products")
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private Double price;
    private String imagePath;
    private String description;
    private SellerDTO seller;

    public Product() {

    }

    public Product(String id, String name, Double price, String path, String description, SellerDTO SellerDTODTO) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imagePath = path;
        this.description = description;
        this.seller = SellerDTODTO;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SellerDTO getSeller() {
        return seller;
    }

    public void setSellerDTODTO(SellerDTO s) {
        this.seller = s;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((seller == null) ? 0 : seller.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (seller == null) {
            if (other.seller != null)
                return false;
        } else if (!seller.equals(other.seller))
            return false;
        return true;
    }

    
    
}
