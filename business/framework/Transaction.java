package edu.mum.cs.cs525.labs.exercises.project.business.framework;

import java.util.Date;

public class Transaction {

    private Date date;
    private double amount;
    private String description;
    private TransactionType transactionType;
    private boolean approved = false;

    public Transaction(double amount, String description, TransactionType transactionType) {
        this.amount = amount;
        this.date = new Date();
        this.description = description;
        this.transactionType = transactionType;
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
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

    public boolean isApproved() {
        return approved;
    }

    void approve() {
        this.approved = true;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", event=" + transactionType +
                '}';
    }
}
