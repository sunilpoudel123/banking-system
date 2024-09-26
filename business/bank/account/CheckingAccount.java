package edu.mum.cs.cs525.labs.exercises.project.business.bank.account;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.AccountOwnerType;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.InterestStrategy;

public class CheckingAccount extends Account {
    private String name;
    private String city;

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    protected double calculateNewBalance() {
        return 0;
    }

    @Override
    protected double calculateTotalDue(double newBalance) {
        return 0;
    }

    public CheckingAccount(String accountNumber, double balance, InterestStrategy interestStrategy, String email, AccountOwnerType accountOwnerType) {
        super(accountNumber, balance ,interestStrategy, email, accountOwnerType);
    }

    @Override
    public String getAccountType() {
        return "Checking Account";
    }
}
