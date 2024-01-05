package com.group6.Medalion.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CustomerFeedback")
public class Feedback {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Customer who provided the feedback
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Performance the feedback is about
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id", nullable = false)
    private Performance performance;

    // Date and time when the feedback was submitted
    @Column(name = "submission_date")
    private LocalDateTime submissionDate;

    // Content of the feedback
    @Column(nullable = false)
    private String content;

    // Status of the feedback (e.g., pending, reviewed)
    private String status;

    // Numerical rating provided in the feedback
    private Integer rating;


    // Default Constructor
    public Feedback() {
    }

    // Parameterized constructor
    // Update the constructor parameters to accept Customer and Performance entities
    public Feedback(Customer customer, Performance performance, LocalDateTime submissionDate,
                    String content, String status, Integer rating) {
        this.customer = customer;
        this.performance = performance;
        this.submissionDate = submissionDate;
        this.content = content;
        this.status = status;
        this.rating = rating;
    }

    // Getters and setters for all attributes
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
