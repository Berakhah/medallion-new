package com.group6.Medalion.controller;

import com.group6.Medalion.entity.Membership;
import com.group6.Medalion.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    // Endpoint to create a new membership
    @PostMapping
    public ResponseEntity<Membership> createMembership(@RequestBody Membership membership) {
        return ResponseEntity.ok(membershipService.createMembership(membership));
    }

    // Endpoint to get a membership by ID
    @GetMapping("/{id}")
    public ResponseEntity<Membership> getMembership(@PathVariable Long id) {
        Membership membership = membershipService.getMembership(id);
        if (membership == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(membership);
    }

    // Endpoint to get all memberships
    @GetMapping
    public List<Membership> getAllMemberships() {
        return membershipService.getAllMemberships();
    }

    // Endpoint to update a membership
    @PutMapping("/{id}")
    public ResponseEntity<Membership> updateMembership(@PathVariable Long id, @RequestBody Membership membershipDetails) {
        return ResponseEntity.ok(membershipService.updateMembership(id, membershipDetails));
    }

    // Endpoint to delete a membership
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembership(@PathVariable Long id) {
        membershipService.deleteMembership(id);
        return ResponseEntity.ok().build();
    }
}
