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
    public Account createAccount(BankAccountType accountType,double balance ,String accountNumber, String email) {
        switch (accountType) {
            case SAVINGS:
                return new SavingsAccount(accountNumber, balance,new SavingInterest(), email);
            case CHECKING:
                return new CheckingAccount(accountNumber, balance,new CheckingInterest(), email);
            default:
                throw new IllegalArgumentException("Unknown bank account type");
        }
    }
}
