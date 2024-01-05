package com.group6.Medalion.controller;

import com.group6.Medalion.entity.Sales;
import com.group6.Medalion.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @PostMapping
    public ResponseEntity<Sales> createSale(@RequestBody Sales sale,
                                            @RequestParam(required = false) String discountCode) {
        // Record the sale with an optional discount code
        Sales newSale = salesService.recordSale(sale, discountCode);
        return new ResponseEntity<>(newSale, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Sales>> getAllSales() {
        List<Sales> sales = salesService.getAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSale(@PathVariable Long id) {
        Sales sale = salesService.getSaleById(id);
        if (sale == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sale);
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<Sales> processPayment(@PathVariable Long id) {
        Sales sale = salesService.getSaleById(id);
        if (sale == null) {
            return ResponseEntity.notFound().build();
        }
        Sales updatedSale = salesService.processPayment(sale);
        return ResponseEntity.ok(updatedSale);
    }
}
