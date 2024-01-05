package com.group6.Medalion.repository;

import com.group6.Medalion.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    // Method to find a discount by its unique code
    Optional<Discount> findByCode(String code);

    // Additional custom methods can be added here as needed
}
