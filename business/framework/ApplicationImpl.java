package edu.mum.cs.cs525.labs.exercises.project.business.framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApplicationImpl implements Subject {
    private AccountDOA accountDOA;
    private List<Observer> observers = new ArrayList<>();

    public ApplicationImpl(AccountDOA accountDOA) {
        this.accountDOA = accountDOA;
    }

    public Account createAccount(AbstractAccountFactory abstractAccountFactory) {
        Account newAccount = abstractAccountFactory.createAccount();
        accountDOA.store(newAccount);
        return newAccount;
    }

    public void deposit(Account account, double amount) {
        Command depositCommand = new DepositCommand(account, amount);
        account.executeTransaction(depositCommand);
        notifyObservers(account);
    }

    public void withdraw(Account account, double amount) {
        Command withdrawCommand = new WithdrawCommand(account, amount);
        account.executeTransaction(withdrawCommand);
        notifyObservers(account);
    }

    public void applyInterestToAllAccount() {
        Collection<Account> accounts = getAccounts();
        for (Account account : accounts) {
            account.applyInterest();
        }
    }

    public void undoLastTransaction(Account account) {
        account.undoLastTransaction();
    }

    public Account getAccount(String accountNumber) {
        return accountDOA.get(accountNumber);
    }

    public Collection<Account> getAccounts() {
        return accountDOA.find();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Account account) {
        for (Observer o : observers) {
            o.update(account);
        }
    }
}