package edu.mum.cs.cs525.labs.exercises.project.business.ccard;

import edu.mum.cs.cs525.labs.exercises.project.business.bank.account.SavingsAccount;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.interest.CheckingInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.factory.CreditCardAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.*;

import java.util.ArrayList;
import java.util.List;

public class CreditCardApplicationImpl extends ApplicationImpl implements ApplicationFacade<CreditCardAccountType> {
    public CreditCardApplicationImpl(AccountDOA accountDOA) {
        super(accountDOA);
    }

    @Override
    public Account createAccount(CreditCardAccountType accountType, double balance, String accountNumber, String email, AccountOwnerType accountOwnerType) {
        return super.createAccount(new CreditCardAccountFactory(accountType, balance, accountNumber, email, accountOwnerType));
    }

}
