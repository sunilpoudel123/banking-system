package edu.mum.cs.cs525.labs.exercises.project.business.ccard.interest;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.InterestStrategy;

public class BronzeCardInterest implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.10; // 10% interest for bronze card
    }
}
