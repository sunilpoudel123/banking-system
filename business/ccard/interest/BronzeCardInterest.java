package edu.mum.cs.cs525.labs.exercises.project.business.ccard.interest;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.InterestStrategy;

import static edu.mum.cs.cs525.labs.exercises.project.business.ccard.ApplicationConfiguration.BRONZE_CARD;

public class BronzeCardInterest implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * BRONZE_CARD.getMonthlyInterestRate();
    }
}
