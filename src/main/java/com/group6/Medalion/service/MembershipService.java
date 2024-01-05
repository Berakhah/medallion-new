package com.group6.Medalion.service;

import com.group6.Medalion.entity.Membership;
import com.group6.Medalion.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    // Method to create a new membership
    public Membership createMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    // Method to get a membership by ID
    public Membership getMembership(Long id) {
        return membershipRepository.findById(id).orElse(null);
    }

    // Method to get all memberships
    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    // Method to update a membership
    public Membership updateMembership(Long id, Membership membershipDetails) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membership not found for this id :: " + id));
        membership.setLevel(membershipDetails.getLevel());
        membership.setBenefits(membershipDetails.getBenefits());
        return membershipRepository.save(membership);
    }

    // Method to delete a membership
    public void deleteMembership(Long id) {
        membershipRepository.deleteById(id);
    }
}
