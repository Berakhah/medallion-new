package com.group6.Medalion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String section;
    private String row;
    private String number;
    private boolean isAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id", nullable = false)
    private Performance performance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    // Constructors
    public Seat() {
    }

    public Seat(String section, String row, String number, boolean isAvailable, Performance performance, Reservation reservation) {
        this.section = section;
        this.row = row;
        this.number = number;
        this.isAvailable = isAvailable;
        this.performance = performance;
        this.reservation = reservation;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", section='" + section + '\'' +
                ", row='" + row + '\'' +
                ", number='" + number + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
