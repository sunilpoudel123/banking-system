package edu.mum.cs.cs525.labs.exercises.project.business.ccard.account;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.InterestStrategy;

public class GoldCard extends Account {
    public GoldCard(String accountNumber, double balance, InterestStrategy interestStrategy) {
        super(accountNumber, balance, interestStrategy);
    }

    @Override
    public String getAccountType() {
        return "Gold Credit Card";
    }
}

