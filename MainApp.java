package edu.mum.cs.cs525.labs.exercises.project;

import edu.mum.cs.cs525.labs.exercises.project.business.bank.BankAccountType;
import edu.mum.cs.cs525.labs.exercises.project.business.bank.factory.BankAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.CreditCardAccountType;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.factory.CreditCardAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.*;

public class MainApp {

    public static void main(String[] args) {
        // Create bank accounts using enums
        AccountFactory<BankAccountType> bankFactory = new BankAccountFactory();
        Account savings = bankFactory.createAccount(BankAccountType.SAVINGS, 0.0,"SAV12345", "first@mail.com");
        Account checking = bankFactory.createAccount(BankAccountType.CHECKING, 0.0,"CHK12345", "second@mail.com");

        // Create credit card accounts using enums
        AccountFactory<CreditCardAccountType> cardFactory = new CreditCardAccountFactory();
        Account goldCard = cardFactory.createAccount(CreditCardAccountType.GOLD,0.0, "GOLD12345", "third@mail.com");
        Account silverCard = cardFactory.createAccount(CreditCardAccountType.SILVER,0.0, "SILV12345", "forth@mail.com");

        ///Command pattern
//        Command deposit1000 = new DepositCommand(savings, 1000);
//        savings.executeTransaction(deposit1000);
        // Deposit money and apply interest
        savings.deposit(1000);
        savings.withdraw(500);
        savings.applyInterest();
        for (Transaction transaction : savings.getTransactions()) {
            System.out.println(transaction);
        }
        System.out.println(savings.getAccountType() + " Balance: " + savings.getBalance());

        checking.deposit(500);
        checking.applyInterest();
        System.out.println(checking.getAccountType() + " Balance: " + checking.getBalance());

        goldCard.deposit(2000);
        goldCard.applyInterest();
        System.out.println(goldCard.getAccountType() + " Balance: " + goldCard.getBalance());

        silverCard.deposit(1500);
        silverCard.applyInterest();
        System.out.println(silverCard.getAccountType() + " Balance: " + silverCard.getBalance());
    }
}
