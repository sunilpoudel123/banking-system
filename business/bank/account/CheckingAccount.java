package edu.mum.cs.cs525.labs.exercises.project.business.bank.account;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.InterestStrategy;

public class CheckingAccount extends Account {

    private String name;
    private String city;
    private String ownershipType;

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    @Override
    protected double calculateNewBalance() {
        return 0;
    }

    @Override
    protected double calculateTotalDue(double newBalance) {
        return 0;
    }

    public CheckingAccount(String accountNumber, double balance, InterestStrategy interestStrategy, String email) {
        super(accountNumber, balance ,interestStrategy, email);
    }

    @Override
    public String getAccountType() {
        return "Checking Account";
    }

}
