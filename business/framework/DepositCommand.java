package edu.mum.cs.cs525.labs.exercises.project.business.framework;

public class DepositCommand implements Command{
    private Account account;
    private double amount;

    public DepositCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
        System.out.println("Deposited " + amount + " to account " + account.getAccountNumber());
    }

    @Override
    public void undo() {
        account.withdraw(amount);
        System.out.println("Undid deposit of " + amount + " from account " + account.getAccountNumber());
    }
}
