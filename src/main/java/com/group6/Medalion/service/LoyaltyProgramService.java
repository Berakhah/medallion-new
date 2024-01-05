package com.group6.Medalion.service;

import com.group6.Medalion.entity.Customer;
import com.group6.Medalion.entity.LoyaltyProgram;
import com.group6.Medalion.exception.CustomerNotFoundException;
import com.group6.Medalion.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyProgramService {

    @Autowired
    private CustomerRepository customerRepository;

    // Logic to enroll a customer in a loyalty program
    public void enrollCustomerInLoyaltyProgram(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
        // Initialize loyalty program with default values
        loyaltyProgram.setCustomer(customer);
        loyaltyProgram.setPoints(0);
        loyaltyProgram.setTier("Bronze"); // Default tier
        customer.setLoyaltyProgram(loyaltyProgram);
        customerRepository.save(customer);
    }

    // Logic to update loyalty points
    public void updateLoyaltyPoints(Long customerId, int points) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));
        LoyaltyProgram loyaltyProgram = customer.getLoyaltyProgram();
        if (loyaltyProgram != null) {
            loyaltyProgram.setPoints(loyaltyProgram.getPoints() + points);
            // Logic to update tier based on points can be added here
        } else {
            throw new IllegalStateException("Customer is not enrolled in any loyalty program");
        }
    }

    // Logic to retrieve loyalty program details
    public LoyaltyProgram getLoyaltyProgramDetails(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + customerId));
        return customer.getLoyaltyProgram();
    }
}

