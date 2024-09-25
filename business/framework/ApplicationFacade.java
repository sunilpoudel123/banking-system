package edu.mum.cs.cs525.labs.exercises.project.business.framework;

import java.util.Collection;
import java.util.List;

public interface ApplicationFacade<T> extends Subject{

    public Account createAccount(T accountType,double balance ,String accountNumber, String email, AccountOwnerType accountOwnerType);

    public void deposit(Account account,double amount);

    public void withdraw(Account account,double amount);

    public void applyInterestToAllAccount();

    public void undoLastTransaction(Account account);

    public Collection<Account> getAccounts();
    public Account getAccount(String accountNumber);
}
