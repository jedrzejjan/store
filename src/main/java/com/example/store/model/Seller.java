package com.example.store.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Seller {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;


    public Seller() {}
    public Seller(String name){
        this.name = name;
    }
}
