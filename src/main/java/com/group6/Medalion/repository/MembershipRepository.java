package com.group6.Medalion.repository;

import com.group6.Medalion.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    // Add custom query methods if required
}
