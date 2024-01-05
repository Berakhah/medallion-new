package com.group6.Medalion.service;

import com.group6.Medalion.entity.Discount;
import com.group6.Medalion.entity.Sales;
import com.group6.Medalion.exception.*;
import com.group6.Medalion.repository.DiscountRepository;
import com.group6.Medalion.repository.SalesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiscountService {
    private static final Logger log = LoggerFactory.getLogger(DiscountService.class);

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private SalesRepository salesRepository;

    // Create a new discount
    public Discount createDiscount(Discount discount) {
        // Validate existing discount code
        discountRepository.findByCode(discount.getCode()).ifPresent(d -> {
            throw new DiscountCodeExistsException("Discount code already exists");
        });

        // Save new discount
        Discount savedDiscount = discountRepository.save(discount);
        log.info("Created discount with code: {}", discount.getCode());
        return savedDiscount;
    }

    // Apply a discount to a sale
    public Sales applyDiscount(Long saleId, String discountCode) {
        // Validate discount and sale
        Discount discount = validateDiscountCode(discountCode);
        Sales sale = validateSaleId(saleId);

        // Calculate discounted amount
        double discountedAmount = calculateDiscountedAmount(sale.getAmount(), discount.getPercentage());
        sale.setAmount(discountedAmount);

        // Update sale record
        log.info("Applied discount code: {} to sale: {}", discountCode, saleId);
        return salesRepository.save(sale);
    }

    // Update existing discount
    public Discount updateDiscount(Long id, Discount updatedDiscount) {
        // Fetch and update discount
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new DiscountNotFoundException("Discount not found with id: " + id));

        // Apply updates
        discount.setCode(updatedDiscount.getCode());
        discount.setDescription(updatedDiscount.getDescription());
        discount.setPercentage(updatedDiscount.getPercentage());
        discount.setValidUntil(updatedDiscount.getValidUntil());

        // Save changes
        log.info("Updated discount with code: {}", discount.getCode());
        return discountRepository.save(discount);
    }

    // Delete a discount
    public void deleteDiscount(Long id) {
        // Validate discount existence
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new DiscountNotFoundException("Discount not found with id: " + id));

        // Perform deletion
        discountRepository.delete(discount);
        log.info("Deleted discount with id: {}", id);
    }

    // Retrieve all discounts
    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    // Helper methods
    private Discount validateDiscountCode(String discountCode) {
        return discountRepository.findByCode(discountCode)
                .orElseThrow(() -> new DiscountNotFoundException("Discount not found"));
    }

    private Sales validateSaleId(Long saleId) {
        return salesRepository.findById(saleId)
                .orElseThrow(() -> new SaleNotFoundException("Sale not found"));
    }

    private double calculateDiscountedAmount(double originalAmount, double discountPercentage) {
        return originalAmount - (originalAmount * discountPercentage / 100);
    }
}
