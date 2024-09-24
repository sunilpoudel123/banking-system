package edu.mum.cs.cs525.labs.exercises.project.business.ccard;

import edu.mum.cs.cs525.labs.exercises.project.business.ccard.factory.CreditCardAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.*;

import java.util.ArrayList;
import java.util.List;

public class CreditCardApplicationImpl implements ApplicationFacade<CreditCardAccountType> {
    List<Account> accounts = new ArrayList<>();

    @Override
    public Account createAccount(CreditCardAccountType accountType, double balance, String accountNumber) {
        CreditCardAccountFactory creditCardAccountFactory = new CreditCardAccountFactory();
        Account newAccount = creditCardAccountFactory.createAccount(accountType,balance, accountNumber);
        this.accounts.add(newAccount);
        return newAccount;
    }

    @Override
    public void deposit(Account account, double amount) {
        Command depositCommand = new DepositCommand(account, amount);
        account.executeTransaction(depositCommand);
    }

    @Override
    public void withdraw(Account account, double amount) {
        Command withdrawCommand = new WithdrawCommand(account, amount);
        account.executeTransaction(withdrawCommand);
    }

    @Override
    public void applyInterestToAllAccount() {
        for (Account account:this.accounts) {
            account.applyInterest();
        }
    }

    @Override
    public void undoLastTransaction(Account account) {
        account.undoLastTransaction();
    }

    @Override
    public List<Account> getAccounts() {
        return this.accounts;
    }
}
