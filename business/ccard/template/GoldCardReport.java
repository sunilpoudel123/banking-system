package edu.mum.cs.cs525.labs.exercises.project.business.ccard.template;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.Report;

import static edu.mum.cs.cs525.labs.exercises.project.business.ccard.ApplicationConfiguration.GOLD_CARD;

public class GoldCardReport extends Report {
    @Override
    protected double calculateNewBalance() {
        return previousBalance - totalCredits + totalCharges + GOLD_CARD.getMonthlyInterestRate() * (previousBalance - totalCredits);
    }

    @Override
    protected double calculateTotalDue(double newBalance) {
        return GOLD_CARD.getMinimumPayment() * newBalance;
    }
}
