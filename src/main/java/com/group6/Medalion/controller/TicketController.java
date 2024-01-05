package com.group6.Medalion.controller;

import com.group6.Medalion.entity.Ticket;
import com.group6.Medalion.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // Issue a ticket
    @PostMapping
    public ResponseEntity<Ticket> issueTicket(@RequestBody Ticket ticket) {
        Ticket issuedTicket = ticketService.issueTicket(ticket);
        return ResponseEntity.ok(issuedTicket);
    }

    // Get a ticket by ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }

    // Cancel a ticket
    @PutMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelTicket(@PathVariable Long id) {
        ticketService.cancelTicket(id);
        return ResponseEntity.ok().build();
    }

    // Update ticket details
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket updatedTicket) {
        Ticket ticket = ticketService.updateTicket(id, updatedTicket);
        return ResponseEntity.ok(ticket);
    }
}
