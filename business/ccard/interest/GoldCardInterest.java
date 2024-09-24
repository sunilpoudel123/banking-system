package edu.mum.cs.cs525.labs.exercises.project.business.ccard.interest;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.InterestStrategy;

public class GoldCardInterest implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.06; // 6% interest for gold card
    }
}
