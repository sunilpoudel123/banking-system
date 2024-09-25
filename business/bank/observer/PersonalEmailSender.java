package edu.mum.cs.cs525.labs.exercises.project.business.bank.observer;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.*;

public class PersonalEmailSender implements Observer {
    private EmailSender emailSender;

    public PersonalEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void update(Account account) {
        Transaction  lastAttempTransaction = account.getLastAttemptTransaction();
        if (account.getOwnershipType().equals("Personal")) {
            if (lastAttempTransaction.getTransactionType().equals(TransactionType.WITHDRAW)
                && !lastAttempTransaction.isApproved()
                && account.getBalance() < lastAttempTransaction.getAmount()) {
                emailSender.sendEmail("info@bank.com", account.getEmail(), "overdrawn", lastAttempTransaction.toString());
            } else if (lastAttempTransaction.isApproved()
                && lastAttempTransaction.getAmount() > 500) {
                emailSender.sendEmail("info@bank.com", account.getEmail(), "notify", lastAttempTransaction.toString());
            }
        }
    }
}
