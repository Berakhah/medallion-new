package com.group6.Medalion.repository;

import com.group6.Medalion.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAvailableSeatsByPerformanceId(Long performanceId);
}
