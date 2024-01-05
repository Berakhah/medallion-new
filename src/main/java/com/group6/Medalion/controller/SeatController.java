package com.group6.Medalion.controller;

import com.group6.Medalion.entity.Seat;
import com.group6.Medalion.service.SeatManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatManagementService seatManagementService;

    // Update seat availability
    @PutMapping("/{seatId}/availability")
    public ResponseEntity<Seat> updateSeatAvailability(@PathVariable Long seatId,
                                                       @RequestParam boolean isAvailable) {
        Seat updatedSeat = seatManagementService.updateSeatAvailability(seatId, isAvailable);
        return ResponseEntity.ok(updatedSeat);
    }

    // Get seat details
    @GetMapping("/{seatId}")
    public ResponseEntity<Seat> getSeatDetails(@PathVariable Long seatId) {
        Seat seat = seatManagementService.getSeatDetails(seatId);
        return ResponseEntity.ok(seat);
    }

    // Get available seats for a performance
    @GetMapping("/performance/{performanceId}")
    public ResponseEntity<List<Seat>> getAvailableSeatsForPerformance(@PathVariable Long performanceId) {
        List<Seat> availableSeats = seatManagementService.getAvailableSeatsForPerformance(performanceId);
        return ResponseEntity.ok(availableSeats);
    }

    // Update seat details
    @PutMapping("/{seatId}")
    public ResponseEntity<Seat> updateSeatDetails(@PathVariable Long seatId,
                                                  @RequestParam String section,
                                                  @RequestParam String row,
                                                  @RequestParam String number) {
        Seat updatedSeat = seatManagementService.updateSeatDetails(seatId, section, row, number);
        return ResponseEntity.ok(updatedSeat);
    }

    // Update seat's performance
    @PutMapping("/{seatId}/performance/{performanceId}")
    public ResponseEntity<Seat> updateSeatPerformance(@PathVariable Long seatId,
                                                      @PathVariable Long performanceId) {
        Seat updatedSeat = seatManagementService.updateSeatPerformance(seatId, performanceId);
        return ResponseEntity.ok(updatedSeat);
    }
}
