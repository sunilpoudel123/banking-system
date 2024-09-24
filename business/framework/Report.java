package edu.mum.cs.cs525.labs.exercises.project.business.framework;

public abstract class Report {
    public Account account;
    protected double previousBalance;
    protected double totalCharges;
    protected double totalCredits;

    public final void generate() {
        calculatePreviousBalance();
        calculateTotalCharges();
        calculateTotalCredits();
        double newBalance = calculateNewBalance();
        double totalDue = calculateTotalDue(newBalance);
        displayReport(newBalance, totalDue);
    }

    protected void calculatePreviousBalance() {
        previousBalance = fetchPreviousBalance();
    }

    protected void calculateTotalCharges() {
        totalCharges = fetchTotalCharges();
    }

    protected void calculateTotalCredits() {
        totalCredits = fetchTotalCredits();
    }

    protected abstract double calculateNewBalance();

    protected abstract double calculateTotalDue(double newBalance);

    private double fetchPreviousBalance() {
        return 1000; //fetch from db
    }

    private double fetchTotalCharges() {
        return 200; // fetch from db
    }

    private double fetchTotalCredits() {
        return 150; // fetch from db
    }

    protected void displayReport(double newBalance, double totalDue) {
        System.out.println("Previous Balance: " + previousBalance);
        System.out.println("Total Charges: " + totalCharges);
        System.out.println("Total Credits: " + totalCredits);
        System.out.println("New Balance: " + newBalance);
        System.out.println("Total Due: " + totalDue);
    }
}
