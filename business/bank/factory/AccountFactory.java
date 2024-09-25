package edu.mum.cs.cs525.labs.exercises.project.business.bank.factory;

import edu.mum.cs.cs525.labs.exercises.project.business.bank.BankAccountType;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.account.CheckingAccount;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.account.SavingsAccount;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.interest.CheckingInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.interest.SavingInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.AbstractAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.AccountOwnerType;

public class AccountFactory implements AbstractAccountFactory {
    BankAccountType accountType;
    private double balance ;
    private String accountNumber;
    private String email;
    private AccountOwnerType accountOwnerType;

    public AccountFactory(BankAccountType accountType, double balance , String accountNumber, String email, AccountOwnerType accountOwnerType) {
        this.accountType = accountType;
        this.balance = balance ;
        this.accountNumber = accountNumber;
        this.email =email;
        this.accountOwnerType = accountOwnerType;
    }

    @Override
    public Account createAccount() {
        switch (accountType) {
            case SAVINGS:
                return new SavingsAccount(accountNumber, balance,new SavingInterest(), email, accountOwnerType);
            case CHECKING:
                return new CheckingAccount(accountNumber, balance,new CheckingInterest(), email, accountOwnerType);
            default:
                throw new IllegalArgumentException("Unknown bank account type");
        }
    }
}
