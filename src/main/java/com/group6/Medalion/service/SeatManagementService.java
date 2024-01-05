package com.group6.Medalion.service;

import com.group6.Medalion.entity.Performance;
import com.group6.Medalion.entity.Seat;
import com.group6.Medalion.exception.PerformanceNotFoundException;
import com.group6.Medalion.exception.SeatNotFoundException;
import com.group6.Medalion.repository.SeatRepository;
import com.group6.Medalion.repository.PerformanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatManagementService {
    private static final Logger log = LoggerFactory.getLogger(SeatManagementService.class);

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private PerformanceRepository performanceRepository;


    public Seat updateSeatAvailability(Long seatId, boolean isAvailable) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new SeatNotFoundException("Seat not found with id " + seatId));
        seat.setIsAvailable(isAvailable);
        Seat updatedSeat = seatRepository.save(seat);
        log.info("Updated seat availability: Seat ID: {}, isAvailable: {}", seatId, isAvailable);
        return updatedSeat;
    }

    public Seat getSeatDetails(Long seatId) {
        return seatRepository.findById(seatId)
                .orElseThrow(() -> new SeatNotFoundException("Seat not found with id " + seatId));
    }

    public List<Seat> getAvailableSeatsForPerformance(Long performanceId) {
        List<Seat> availableSeats = seatRepository.findAvailableSeatsByPerformanceId(performanceId);
        log.info("Retrieved available seats for performance ID: {}", performanceId);
        return availableSeats;
    }

    public Seat updateSeatDetails(Long seatId, String section, String row, String number) {
        Seat seat = getSeatDetails(seatId);
        seat.setSection(section);
        seat.setRow(row);
        seat.setNumber(number);
        return seatRepository.save(seat);
    }

    public Seat updateSeatPerformance(Long seatId, Long performanceId) {
        Seat seat = getSeatDetails(seatId);
        Performance performance = performanceRepository.findById(performanceId)
                .orElseThrow(() -> new PerformanceNotFoundException("Performance not found with id " + performanceId));

        seat.setPerformance(performance);
        return seatRepository.save(seat);
    }


}
