package edu.mum.cs.cs525.labs.exercises.project.business.framework;

public class WithdrawCommand implements Command{
    private Account account;
    private double amount;

    public WithdrawCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdraw(amount);
        System.out.println("Withdrew " + amount + " from account " + account.getAccountNumber());
    }

    @Override
    public void undo() {
        account.deposit(amount);
        System.out.println("Undid withdrawal of " + amount + " from account " + account.getAccountNumber());
    }
}
