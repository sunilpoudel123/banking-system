package edu.mum.cs.cs525.labs.exercises.project.business.framework;

import java.time.LocalDateTime;
import java.util.Date;

public class Entry {

    private Date date;
    private double amount;
    private String description;
    private Event event;

    public Entry(double amount, String description, Event event) {
        this.amount = amount;
        this.date = new Date();
        this.description = description;
        this.event = event;
    }

    public Event getEvent() {
        return this.event;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", event=" + event +
                '}';
    }
}
