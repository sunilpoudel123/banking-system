package edu.mum.cs.cs525.labs.exercises.project.business.bank.observer;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.EmailSender;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.Observer;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.Transaction;

public class CompanyEmailSender implements Observer {
    private EmailSender emailSender;

    public CompanyEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void update(Account account) {
        Transaction lastAttempTransaction = account.getLastAttemptTransaction();
        if (account.getOwnershipType().equals("Company")) {
            emailSender.sendEmail("info@bank.com", account.getEmail(), "notify", lastAttempTransaction.toString());
        }
    }
}
