package com.group6.Medalion.repository;

import com.group6.Medalion.entity.LoyaltyProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyProgramRepository extends JpaRepository<LoyaltyProgram, Long> {
    // This repository can include custom query methods for LoyaltyProgram entity if needed.
}
