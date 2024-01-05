package com.group6.Medalion.service.impl;

import com.group6.Medalion.entity.Performance;
import com.group6.Medalion.repository.PerformanceRepository;
import com.group6.Medalion.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Override
    public Performance addPerformance(Performance performance) {
        // Validation for performance date
        if (performance.getDateTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Performance date and time must be in the future.");
        }
        return performanceRepository.save(performance);
    }

    @Override
    public Optional<Performance> getPerformanceById(Long id) {
        return performanceRepository.findById(id);
    }

    @Override
    public Performance updatePerformance(Long id, Performance updatedPerformance) {
        return performanceRepository.findById(id)
                .map(performance -> {
                    performance.setDateTime(updatedPerformance.getDateTime());
                    if (updatedPerformance.getShow() != null) {
                        performance.setShow(updatedPerformance.getShow());
                    }
                    return performanceRepository.save(performance);
                })
                .orElseThrow(() -> new RuntimeException("Performance not found with id: " + id));
    }

    @Override
    public void deletePerformance(Long id) {
        if (!performanceRepository.existsById(id)) {
            throw new RuntimeException("Performance not found with id: " + id);
        }
        performanceRepository.deleteById(id);
    }

    @Override
    public List<Performance> getPerformancesForShow(Long showId) {
        return performanceRepository.findByShow_ShowId(showId);
    }
}

