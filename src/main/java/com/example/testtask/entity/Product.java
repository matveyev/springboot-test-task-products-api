package com.example.testtask.entity;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    public Product() {
        Id = new Long(0);
        Name = "Default";
        Amount = new Long(1);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;

    @Column(name="name")
    private String Name;

    @Column(name="amount")
    private Long Amount;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getAmount() {
        return Amount;
    }

    public void setAmount(Long amount) {
        Amount = amount;
    }
}
