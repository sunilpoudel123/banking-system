package edu.mum.cs.cs525.labs.exercises.project.business.framework;

import java.util.Collection;

public interface AccountDOA {
    void store(Account account);
    Account get(String accountNumber);
    Collection<Account> find();
}
