package com.group6.Medalion.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDateTime eventDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;

    // Default constructor
    public Event() {
    }

    // Parameterized constructor
    public Event(String title, LocalDateTime eventDate, Show show) {
        this.title = title;
        this.eventDate = eventDate;
        this.show = show;
    }

    // Getter for ID
    public Long getId() {
        return id;
    }

    // Setter for ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for Title
    public String getTitle() {
        return title;
    }

    // Setter for Title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for EventDate
    public LocalDateTime getEventDate() {
        return eventDate;
    }

    // Setter for EventDate
    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    // Getter for Show
    public Show getShow() {
        return show;
    }

    // Setter for Show
    public void setShow(Show show) {
        this.show = show;
    }

    // toString method for debugging and logging
    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", show=" + (show != null ? show.getShowId() : null) +
                '}';
    }
}
