package edu.mum.cs.cs525.labs.exercises.project.business.bank;

import edu.mum.cs.cs525.labs.exercises.project.business.bank.account.SavingsAccount;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.factory.BankAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.interest.CheckingInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.interest.CheckingInterest;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.*;

import java.util.ArrayList;
import java.util.List;

public class BankApplicationImpl implements ApplicationFacade<BankAccountType>, Subject {
    List<Account> accounts = new ArrayList<>();
    List<Observer> observers = new ArrayList<>();

    @Override
    public Account createAccount(BankAccountType accountType, double balance, String accountNumber, String email) {
        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        Account newAccount = bankAccountFactory.createAccount(accountType, balance, accountNumber, email);
        this.accounts.add(newAccount);
        return newAccount;
    }

    @Override
    public void deposit(Account account, double amount) {
        Command depositCommand = new DepositCommand(account, amount);
        account.executeTransaction(depositCommand);
        notifyObservers(account);
    }

    @Override
    public void withdraw(Account account, double amount) {
        Command withdrawCommand = new WithdrawCommand(account, amount);
        account.executeTransaction(withdrawCommand);
        notifyObservers(account);
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
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Account account) {
        for (Observer o : observers) {
            o.update(account);
        }
    }

    @Override
    public Account getAccount(String accountNumber) {
        return this.accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findAny()
                .orElse(createDummyAccount()); // Return null if no matching account is found
    }

    private Account createDummyAccount() {
        Account dummyAccount = new SavingsAccount("123", 400, new CheckingInterest(), "email");
        return dummyAccount;
    }
}
