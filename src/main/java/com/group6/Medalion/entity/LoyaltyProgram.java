package com.group6.Medalion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LoyaltyProgram")
public class LoyaltyProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer points; // Stores loyalty points
    private String tier; // e.g., Gold, Silver

    @OneToOne(mappedBy = "loyaltyProgram")
    private Customer customer;

    // Default Constructor
    public LoyaltyProgram() {
    }

    // Parameterized Constructor
    public LoyaltyProgram(Integer points, String tier, Customer customer) {
        this.points = points;
        this.tier = tier;
        this.customer = customer;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}



