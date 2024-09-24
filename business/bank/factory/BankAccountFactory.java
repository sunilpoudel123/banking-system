package edu.mum.cs.cs525.labs.exercises.project.business.bank.factory;

import edu.mum.cs.cs525.labs.exercises.project.business.bank.BankAccountType;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.account.CheckingAccount;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.account.SavingsAccount;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.interest.CheckingInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.interest.SavingInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.AccountFactory;

public class BankAccountFactory extends AccountFactory<BankAccountType> {
    @Override
    public Account createAccount(BankAccountType accountType,double balance ,String accountNumber) {
        switch (accountType) {
            case SAVINGS:
                return new SavingsAccount(accountNumber, balance,new SavingInterest());
            case CHECKING:
                return new CheckingAccount(accountNumber, balance,new CheckingInterest());
            default:
                throw new IllegalArgumentException("Unknown bank account type");
        }
    }
}
