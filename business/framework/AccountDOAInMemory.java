package edu.mum.cs.cs525.labs.exercises.project.business.framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountDOAInMemory implements AccountDOA {
    Collection<Account> accounts;

    public AccountDOAInMemory () {
        accounts = new ArrayList<>();
    }

    @Override
    public void store(Account account) {
        accounts.add(account);
    }

    @Override
    public Account get(String accountNumber) {
        return accounts
                .stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findAny()
                .orElse(null);
    }

    @Override
    public Collection<Account> find() {
        return accounts;
    }
}
