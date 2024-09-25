package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;


import edu.mum.cs.cs525.labs.exercises.project.business.ccard.observer.CompanyEmailSender;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.observer.PersonalEmailSender;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.CreditCardAccountType;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.CreditCardApplicationImpl;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.account.BronzeCard;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.account.GoldCard;
import edu.mum.cs.cs525.labs.exercises.project.business.ccard.account.SilverCard;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.ApplicationFacade;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.EmailSender;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.MockEmailSender;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 * A basic JFC based application.
 */
public class CardFrm extends javax.swing.JFrame {
    /****
     * init variables in the object
     ****/
    String clientName, street, city, zip, state, amountDeposit, expdate, ccnumber, email;

    CreditCardAccountType accountType = CreditCardAccountType.GOLD;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    CardFrm thisframe;
    private Object rowdata[];

    private ApplicationFacade<CreditCardAccountType> applicationFacade;


    public CardFrm() {
        thisframe = this;
        setTitle("Credit-card processing Application.");
        this.applicationFacade = new CreditCardApplicationImpl();
        EmailSender mockEmailSender = new MockEmailSender();
        this.applicationFacade.addObserver(new CompanyEmailSender(mockEmailSender));
        this.applicationFacade.addObserver(new PersonalEmailSender(mockEmailSender));
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(575, 310);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 575, 310);

		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");
        model.addColumn("Email");
        rowdata = new Object[7];
        newaccount = false;

        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 444, 160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
        //rowdata = new Object[8];

        JButton_NewCCAccount.setText("Add Credit-card account");
        JPanel1.add(JButton_NewCCAccount);
        JButton_NewCCAccount.setBounds(24, 20, 192, 33);
        JButton_GenBill.setText("Generate Monthly bills");
        JButton_GenBill.setActionCommand("jbutton");
        JPanel1.add(JButton_GenBill);
        JButton_GenBill.setBounds(240, 20, 192, 33);
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        JButton_Withdraw.setText("Charge");
        JPanel1.add(JButton_Withdraw);
        JButton_Withdraw.setBounds(468, 164, 96, 33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 31);

        JButton_Addinterest.setBounds(448, 20, 106, 33);
        JButton_Addinterest.setText("Add interest");
        JPanel1.add(JButton_Addinterest);

        JButton_GenBill.setActionCommand("jbutton");

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_NewCCAccount.addActionListener(lSymAction);
        JButton_GenBill.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);
        JButton_Addinterest.addActionListener(lSymAction);

    }
    /*****************************************************
     * The entry point for this application.
     * Sets the Look and Feel to the System Look and Feel.
     * Creates a new JFrame1 and makes it visible.
     *****************************************************/
    static public void main(String args[]) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (new CardFrm()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

    javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
    javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
    javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
    javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
    javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();

    javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();

    javax.swing.JButton JButton_Exit = new javax.swing.JButton();

    void exitApplication() {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter {
        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == CardFrm.this) BankFrm_windowClosing(event);
        }
    }

    void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
        // to do: code goes here.

        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_Exit) JButtonExit_actionPerformed(event);
            else if (object == JButton_NewCCAccount) JButtonNewCCAC_actionPerformed(event);
            else if (object == JButton_GenBill) JButtonGenerateBill_actionPerformed(event);
            else if (object == JButton_Deposit) JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Withdraw) JButtonWithdraw_actionPerformed(event);
            else if (object == JButton_Addinterest)
                JButtonAddinterest_actionPerformed(event);
        }
    }

    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
        System.exit(0);
    }

    void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/

        if (this.accountType.equals(CreditCardAccountType.GOLD)) {
            GoldCard newAccount = (GoldCard) this.applicationFacade.createAccount(accountType, 0.0, ccnumber, email);
            newAccount.setType(city);
            newAccount.setName(clientName);

            // TODO: make ui support ownership
            newAccount.setOwnershipType("Personal");
        } else if (this.accountType.equals(CreditCardAccountType.SILVER)) {
            SilverCard newAccount = (SilverCard) this.applicationFacade.createAccount(accountType, 0.0, ccnumber, email);
            newAccount.setType(city);
            newAccount.setName(clientName);

            // TODO: make ui support ownership
            newAccount.setOwnershipType("Personal");
        }else {
            BronzeCard newAccount = (BronzeCard) this.applicationFacade.createAccount(accountType, 0.0, ccnumber, email);
            newAccount.setType(city);
            newAccount.setName(clientName);

            // TODO: make ui support ownership
            newAccount.setOwnershipType("Personal");
        }

        JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe);
        ccac.setBounds(450, 20, 300, 380);
        ccac.show();

        if (newaccount) {
            // add row to table
            rowdata[0] = clientName;
            rowdata[1] = ccnumber;
            rowdata[2] = expdate;
            rowdata[3] = accountType;
            rowdata[4] = "0";
            rowdata[5] = email;
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }
    }

    void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {
        JDialogGenBill billFrm = new JDialogGenBill();
        billFrm.setBounds(450, 20, 400, 350);
        billFrm.show();

    }

    void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String name = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding deposit amount for the current mane
            JDialog_Deposit dep = new JDialog_Deposit(thisframe, name);
            dep.setBounds(430, 15, 275, 140);
            dep.show();

            Account account = this.applicationFacade.getAccounts().get(selection);
            this.applicationFacade.deposit(account, Double.valueOf(amountDeposit));

            // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String) model.getValueAt(selection, 4);
            long currentamount = Long.parseLong(samount);
            long newamount = currentamount + deposit;
            model.setValueAt(String.valueOf(newamount), selection, 4);
        }
    }

    void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String name = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding withdraw amount for the current mane
            JDialog_Withdraw wd = new JDialog_Withdraw(thisframe, name);
            wd.setBounds(430, 15, 275, 140);
            wd.show();

            Account account = this.applicationFacade.getAccounts().get(selection);
            this.applicationFacade.withdraw(account, Double.valueOf(amountDeposit));
            // compute new amount
            long deposit = Long.parseLong(amountDeposit);
            String samount = (String) model.getValueAt(selection, 4);
            long currentamount = Long.parseLong(samount);
            long newamount = currentamount - deposit;
            model.setValueAt(String.valueOf(newamount), selection, 4);
            if (newamount < 0) {
                JOptionPane.showMessageDialog(JButton_Withdraw, " " + name + " Your balance is negative: $" + String.valueOf(newamount) + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
        this.applicationFacade.applyInterestToAllAccount();
        for (int i = 0; i < this.applicationFacade.getAccounts().size(); i++) {
            model.setValueAt(this.applicationFacade.getAccounts().get(i).getBalance(),i,4);
        }
        JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
    }
}
