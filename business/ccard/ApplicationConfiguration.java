package edu.mum.cs.cs525.labs.exercises.project.business.ccard;

public enum ApplicationConfiguration {
    GOLD_CARD(0.06, 50.0),
    SILVER_CARD(0.08, 30.0),
    BRONZE_CARD(0.10, 20.0);

    private final double monthlyInterestRate;
    private final double minimumPayment;

    ApplicationConfiguration(double monthlyInterestRate, double minimumPayment) {
        this.monthlyInterestRate = monthlyInterestRate;
        this.minimumPayment = minimumPayment;
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public double getMinimumPayment() {
        return minimumPayment;
    }
}