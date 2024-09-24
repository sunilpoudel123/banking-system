package edu.mum.cs.cs525.labs.exercises.project.business.ccard.template;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.Report;

import static edu.mum.cs.cs525.labs.exercises.project.business.ccard.ApplicationConfiguration.BRONZE_CARD;

public class BronzeCardReport extends Report {
    @Override
    protected double calculateNewBalance() {
        return previousBalance - totalCredits + totalCharges + BRONZE_CARD.getMonthlyInterestRate() * (previousBalance - totalCredits);
    }

    @Override
    protected double calculateTotalDue(double newBalance) {
        return BRONZE_CARD.getMinimumPayment() * newBalance;
    }
}
