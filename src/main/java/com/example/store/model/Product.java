package com.example.store.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    public @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    public String name;
    public String category;
    public @ManyToOne
    Seller seller;

    public Product(){}
    public Product(String name){
        this.name = name;
    }
    public Product(String name, String category){
        this.name = name;
        this.category = category;
    }
    public Product(String name, String category, Seller seller){
        this.name = name;
        this.category = category;
        this.seller = seller;
    }

}
