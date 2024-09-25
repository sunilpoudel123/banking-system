package edu.mum.cs.cs525.labs.exercises.project.business.ccard.factory;

import edu.mum.cs.cs525.labs.exercises.project.business.ccard.CreditCardAccountType;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.account.BronzeCard;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.account.GoldCard;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.account.SilverCard;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.interest.BronzeCardInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.interest.GoldCardInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.interest.SilverCardInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.AbstractAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.AccountOwnerType;

public class CreditCardAccountFactory implements AbstractAccountFactory {
    private CreditCardAccountType accountType;
    private double balance ;
    private String accountNumber;
    private String email;
    private AccountOwnerType accountOwnerType;

    public CreditCardAccountFactory(CreditCardAccountType accountType, double balance , String accountNumber, String email, AccountOwnerType accountOwnerType) {
        this.accountType = accountType;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.email = email;
        this.accountOwnerType = accountOwnerType;
    }

    @Override
    public Account createAccount() {
        switch (accountType) {
            case GOLD:
                return new GoldCard(accountNumber,balance, new GoldCardInterest(), email, accountOwnerType);
            case SILVER:
                return new SilverCard(accountNumber,balance ,new SilverCardInterest(), email, accountOwnerType);
            case BRONZE:
                return new BronzeCard(accountNumber,balance, new BronzeCardInterest(), email, accountOwnerType);
            default:
                throw new IllegalArgumentException("Unknown credit card account type");
        }
    }
}
