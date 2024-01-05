package com.group6.Medalion.controller;

import com.group6.Medalion.entity.LoyaltyProgram;
import com.group6.Medalion.service.LoyaltyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loyalty")
public class LoyaltyProgramController {

    @Autowired
    private LoyaltyProgramService loyaltyProgramService;

    // Endpoint to enroll a customer in the loyalty program
    @PostMapping("/enroll/{customerId}")
    public ResponseEntity<?> enrollCustomer(@PathVariable Long customerId) {
        try {
            loyaltyProgramService.enrollCustomerInLoyaltyProgram(customerId);
            return ResponseEntity.ok("Customer enrolled in loyalty program successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint to update loyalty points for a customer
    @PutMapping("/update-points/{customerId}")
    public ResponseEntity<?> updatePoints(@PathVariable Long customerId, @RequestBody int points) {
        try {
            loyaltyProgramService.updateLoyaltyPoints(customerId, points);
            return ResponseEntity.ok("Loyalty points updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint to get loyalty program details for a customer
    @GetMapping("/{customerId}")
    public ResponseEntity<?> getLoyaltyDetails(@PathVariable Long customerId) {
        try {
            LoyaltyProgram loyaltyProgram = loyaltyProgramService.getLoyaltyProgramDetails(customerId);
            return ResponseEntity.ok(loyaltyProgram);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
