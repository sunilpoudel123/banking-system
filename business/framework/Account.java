package edu.mum.cs.cs525.labs.exercises.project.business.framework;

import java.util.ArrayList;
import java.util.List;

// framework/Account.java
public abstract class Account {
    private String accountNumber;
    private double balance;
    private InterestStrategy interestStrategy;
    private String email;

    protected AccountInvoker invoker = new AccountInvoker(); // Invoker for commands

    private final List<Transaction> transactions = new ArrayList<Transaction>();
    private Transaction lastAttemptTransaction;

    public Account(String accountNumber, double balance, InterestStrategy interestStrategy, String email) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestStrategy = interestStrategy;
        this.email = email;
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
        Transaction transaction = new Transaction(amount, "", TransactionType.DEPOSIT);
        lastAttemptTransaction = transaction;
        addTransaction(transaction);
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public Transaction getLastAttemptTransaction() {
        return lastAttemptTransaction;
    }

    public void withdraw(double amount) {
        Transaction transaction = new Transaction(amount, "", TransactionType.WITHDRAW);
        lastAttemptTransaction = transaction;
        if (balance >= amount) {
            balance -= amount;
            addTransaction(transaction);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void applyInterest() {
        balance += interestStrategy.calculateInterest(balance);
    }

    public abstract String getAccountType();

    public abstract String getOwnershipType();

    public void executeTransaction(Command command) {
        invoker.executeCommand(command);
    }

    // Undo the last transaction
    public void undoLastTransaction() {
        invoker.undoLastCommand();
    }

    public String getEmail() {
        return email;
    }

    private void addTransaction(Transaction transaction) {
        transaction.approve();
        this.transactions.add(transaction);
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

    public final String generate() {
        double newBalance = calculateNewBalance();
        double totalDue = calculateTotalDue(newBalance);
        return "Previous Balance: " + getPreviousBalance() + "\n" +
                "Total Charges: " + getTotalCharges() + "\n" +
                "Total Credits: " + getTotalCredits() + "\n" +
                "New Balance: " + newBalance + "\n" +
                "Total Due: " + totalDue;
    }

    protected abstract double calculateNewBalance();

    protected abstract double calculateTotalDue(double newBalance);

}
