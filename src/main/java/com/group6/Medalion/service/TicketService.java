package com.group6.Medalion.service;

import com.group6.Medalion.entity.Ticket;
import com.group6.Medalion.exception.ResourceNotFoundException;
import com.group6.Medalion.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket issueTicket(Ticket ticket) {
        // Additional business logic and validations before issuing a ticket
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + id));
    }

    public void cancelTicket(Long id) {
        Ticket ticket = getTicketById(id);
        ticket.setCanceled(true);  // Mark the ticket as canceled
        ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Ticket ticket = getTicketById(id);
        // Update ticket details as per updatedTicket
        ticket.setCustomerEmail(updatedTicket.getCustomerEmail());
        ticket.setReservation(updatedTicket.getReservation());
        ticket.setSeatNumber(updatedTicket.getSeatNumber());
        ticket.setPrice(updatedTicket.getPrice());
        return ticketRepository.save(ticket);
    }
}
