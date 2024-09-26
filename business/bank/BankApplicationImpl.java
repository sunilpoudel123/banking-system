package edu.mum.cs.cs525.labs.exercises.project.business.bank;

import edu.mum.cs.cs525.labs.exercises.project.business.bank.factory.BankAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.*;

public class BankApplicationImpl extends ApplicationImpl implements ApplicationFacade<BankAccountType> {
    public BankApplicationImpl(AccountDOA accountDOA) {
        super(accountDOA);
    }

    @Override
    public Account createAccount(BankAccountType accountType, double balance, String accountNumber, String email, AccountOwnerType accountOwnerType) {
        return super.createAccount(new BankAccountFactory(accountType, balance, accountNumber, email, accountOwnerType));
    }
}
