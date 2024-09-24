package edu.mum.cs.cs525.labs.exercises.project.business.framework;

import java.util.ArrayList;
import java.util.List;

// framework/Account.java
public abstract class Account {
    private String accountNumber;
    private double balance;
    private InterestStrategy interestStrategy;

    protected AccountInvoker invoker = new AccountInvoker(); // Invoker for commands

    private final List<Entry> entryList = new ArrayList<Entry>();

    public Account(String accountNumber, double balance,InterestStrategy interestStrategy) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestStrategy = interestStrategy;
    }

    public void setInterestStrategy(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        Entry entry = new Entry(amount,"",Event.DEPOSIT);
        this.entryList.add(entry);
    }

    public List<Entry> getEntryList() {
        return this.entryList;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            Entry entry = new Entry(amount,"",Event.WITHDRAW);
            this.entryList.add(entry);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void applyInterest() {

    }

    public abstract String getAccountType();

    public void executeTransaction(Command command) {
        invoker.executeCommand(command);
    }

    // Undo the last transaction
    public void undoLastTransaction() {
        invoker.undoLastCommand();
    }

    public double getPreviousBalance() {
        return getBalance();
    }

    public double getTotalCharges() {
        return 0.0;
    }

    public double getTotalCredits() {
        return 0.0;
    }

    public double getInterestRate() {
        return 0.0;
    }
}
