package edu.mum.cs.cs525.labs.exercises.project.business.bank.interest;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.InterestStrategy;

public class SavingInterest implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.05; // 5% interest for savings
    }
}
