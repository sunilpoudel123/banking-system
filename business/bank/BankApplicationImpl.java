package edu.mum.cs.cs525.labs.exercises.project.business.bank;

import edu.mum.cs.cs525.labs.exercises.project.business.bank.account.SavingsAccount;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.factory.BankAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.interest.CheckingInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.*;

import java.util.ArrayList;
import java.util.List;

public class BankApplicationImpl implements ApplicationFacade<BankAccountType> {
    List<Account> accounts = new ArrayList<>();

    @Override
    public Account createAccount(BankAccountType accountType, double balance, String accountNumber) {
        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        Account newAccount = bankAccountFactory.createAccount(accountType, balance, accountNumber);
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
        for (Account account : this.accounts) {
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

    @Override
    public Account getAccount(String accountNumber) {
        return this.accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findAny()
                .orElse(createDummyAccount()); // Return null if no matching account is found
    }

    private Account createDummyAccount() {
        Account dummyAccount = new SavingsAccount("123", 400, new CheckingInterest());
        return dummyAccount;
    }
}
