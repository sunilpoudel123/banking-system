package edu.mum.cs.cs525.labs.exercises.project.business.framework;

public abstract class AccountFactory<T> {
    public abstract Account createAccount(T accountType,double balance, String accountNumber, String email);
}