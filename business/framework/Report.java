package edu.mum.cs.cs525.labs.exercises.project.business.framework;

public abstract class Report {
    private Account account;
    protected double previousBalance;
    protected double totalCharges;
    protected double totalCredits;

    public Report(Account account) {
        this.account = account;
    }

    public final String generate() {
        calculatePreviousBalance();
        calculateTotalCharges();
        calculateTotalCredits();
        double newBalance = calculateNewBalance();
        double totalDue = calculateTotalDue(newBalance);
        displayReport(newBalance, totalDue);
        return generateReportString(newBalance, totalDue);
    }

    private String generateReportString(double newBalance, double totalDue) {
        return "Previous Balance: " + previousBalance + "\n" +
                "Total Charges: " + totalCharges + "\n" +
                "Total Credits: " + totalCredits + "\n" +
                "New Balance: " + newBalance + "\n" +
                "Total Due: " + totalDue;
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
        return this.account.getPreviousBalance();
    }

    private double fetchTotalCharges() {
        return this.account.getTotalCharges(); // fetch from db
    }

    private double fetchTotalCredits() {
        return this.account.getTotalCredits(); // fetch from db
    }

    protected void displayReport(double newBalance, double totalDue) {
        System.out.println("Previous Balance: " + previousBalance);
        System.out.println("Total Charges: " + totalCharges);
        System.out.println("Total Credits: " + totalCredits);
        System.out.println("New Balance: " + newBalance);
        System.out.println("Total Due: " + totalDue);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
