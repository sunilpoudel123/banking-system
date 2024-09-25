package edu.mum.cs.cs525.labs.exercises.project.business.ccard.observer;

import edu.mum.cs.cs525.labs.exercises.project.business.framework.*;

public class CompanyEmailSender implements Observer {
    private EmailSender emailSender;

    public CompanyEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void update(Account account) {
        Transaction lastAttempTransaction = account.getLastAttemptTransaction();
        if (account.getAccountOwnerType().equals(AccountOwnerType.COMPANY)) {
            emailSender.sendEmail("info@bank.com", account.getEmail(), "notify", lastAttempTransaction.toString());
        }
    }
}
