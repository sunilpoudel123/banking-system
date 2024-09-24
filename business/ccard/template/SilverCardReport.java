package edu.mum.cs.cs525.labs.exercises.project.business.ccard.template;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.Report;

import static edu.mum.cs.cs525.labs.exercises.project.business.ccard.ApplicationConfiguration.SILVER_CARD;

public class SilverCardReport extends Report {
    @Override
    protected double calculateNewBalance() {
        return previousBalance - totalCredits + totalCharges + SILVER_CARD.getMonthlyInterestRate() * (previousBalance - totalCredits);
    }

    @Override
    protected double calculateTotalDue(double newBalance) {
        return SILVER_CARD.getMinimumPayment() * newBalance;
    }
}
