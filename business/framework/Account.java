package edu.mum.cs.cs525.labs.exercises.project.business.framework;

import java.util.ArrayList;
import java.util.List;

// framework/Account.java
public abstract class Account {
    private String accountNumber;
    private double balance;
    private InterestStrategy interestStrategy;

    protected AccountInvoker invoker = new AccountInvoker(); // Invoker for commands

    private final List<Transaction> transactions = new ArrayList<Transaction>();

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
        Transaction transaction = new Transaction(amount,"", TransactionType.DEPOSIT);
        this.transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            Transaction transaction = new Transaction(amount,"", TransactionType.WITHDRAW);
            this.transactions.add(transaction);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void applyInterest() {
        balance += interestStrategy.calculateInterest(balance);
    }

    public abstract String getAccountType();

    public void executeTransaction(Command command) {
        invoker.executeCommand(command);
    }

    // Undo the last transaction
    public void undoLastTransaction() {
        invoker.undoLastCommand();
    }

}
