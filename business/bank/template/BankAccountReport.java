package edu.mum.cs.cs525.labs.exercises.project.business.bank.template;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.Report;

public class BankAccountReport extends Report {

    @Override
    protected double calculateNewBalance() {
        return 0;
    }

    @Override
    protected double calculateTotalDue(double newBalance) {
        return 0;
    }
}
