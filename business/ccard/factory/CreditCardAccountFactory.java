package edu.mum.cs.cs525.labs.exercises.project.business.ccard.factory;

import edu.mum.cs.cs525.labs.exercises.project.business.ccard.CreditCardAccountType;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.account.BronzeCard;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.account.GoldCard;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.account.SilverCard;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.interest.BronzeCardInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.interest.GoldCardInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.interest.SilverCardInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.AccountFactory;

public class CreditCardAccountFactory extends AccountFactory<CreditCardAccountType> {
    @Override
    public Account createAccount(CreditCardAccountType accountType,double balance , String accountNumber, String email) {
        switch (accountType) {
            case GOLD:
                return new GoldCard(accountNumber,balance, new GoldCardInterest(), email);
            case SILVER:
                return new SilverCard(accountNumber,balance ,new SilverCardInterest(), email);
            case BRONZE:
                return new BronzeCard(accountNumber,balance, new BronzeCardInterest(), email);
            default:
                throw new IllegalArgumentException("Unknown credit card account type");
        }
    }
}
