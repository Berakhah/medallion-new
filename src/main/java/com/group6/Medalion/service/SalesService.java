package com.group6.Medalion.service;

import com.group6.Medalion.entity.Sales;
import com.group6.Medalion.exception.*;
import com.group6.Medalion.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private DiscountService discountService; // Inject DiscountService

    public Sales recordSale(Sales sale, String discountCode) {
        // Additional business logic and validations
        if (discountCode != null && !discountCode.isEmpty()) {
            // Apply discount if a discount code is provided
            sale = discountService.applyDiscount(sale.getId(), discountCode);
        }

        return salesRepository.save(sale);
    }

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Sales processPayment(Sales sale) {
        // Check if the sale is already processed
        if ("PAID".equals(sale.getPaymentStatus())) {
            throw new IllegalStateException("Payment already processed for this sale");
        }

        // Logic to handle payment processing
        // This could involve integration with a payment gateway or service
        boolean paymentSuccessful = processExternalPayment(sale);

        // Update the payment status based on the payment process result
        if (paymentSuccessful) {
            sale.setPaymentStatus("PAID");
        } else {
            sale.setPaymentStatus("FAILED");
            // Additional handling for failed payments
        }

        // Save the updated sale record
        return salesRepository.save(sale);
    }

    // Method to retrieve a sale by ID
    public Sales getSaleById(Long id) {
        return salesRepository.findById(id)
                .orElseThrow(() -> new SaleNotFoundException("Sale not found with id " + id));
    }

    // Mock implementation for external payment processing
    private boolean processExternalPayment(Sales sale) {
        // TODO: Implement actual payment processing logic
        // For demonstration, assuming the payment is successful
        return true;
    }
}
